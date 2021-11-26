package com.bradesco.bravoip.manager

import android.app.Application
import com.bradesco.bravoip.impl.avaya.di.braVoIPKoinMainModule
import com.bradesco.bravoip.impl.avaya.domain.usecases.AVIRequestTokenUseCase
import com.bradesco.bravoip.impl.avaya.domain.usecases.AVIStartCallUseCase
import com.bradesco.bravoip.impl.avaya.presentation.AVVoIPImpl
import com.bradesco.bravoip.interfaces.BRAIVoIP
import com.bradesco.bravoip.interfaces.BRAIVoIPEventListener
import com.bradesco.bravoip.interfaces.BRAIVoIPParams
import org.koin.core.context.loadKoinModules
import org.koin.java.KoinJavaComponent.get

class BRAVoIPManager {

    fun getBRAVoIPImpl(): BRAIVoIP {
        return braVoIP
    }

    companion object {
        private lateinit var braVoIP: BRAIVoIP
        private lateinit var INSTANCE: BRAVoIPManager
        private lateinit var braVoIPStore: BRAVoIPStore

        fun getInstance(
            androidApplication: Application,
            voIPParams: BRAIVoIPParams,
            eventListener: BRAIVoIPEventListener): BRAVoIPManager {
            if (!::braVoIPStore.isInitialized) {
                getInstance()
            }
            braVoIPStore.voIPParams = voIPParams
            braVoIPStore.eventListener = eventListener
            braVoIPStore.setApplication(androidApplication)

            return getInstance()
        }

        fun getInstance(): BRAVoIPManager {

            if (!this::INSTANCE.isInitialized) {
                loadKoinModules(
                    arrayListOf(braVoIPKoinMainModule)
                )
            }

            INSTANCE = BRAVoIPManager()

            braVoIPStore = BRAVoIPStore()

            braVoIP = AVVoIPImpl(
                braVoIPStore,
                get(AVIRequestTokenUseCase::class.java),
                get(AVIStartCallUseCase::class.java)
            )

            return INSTANCE
        }
    }
}