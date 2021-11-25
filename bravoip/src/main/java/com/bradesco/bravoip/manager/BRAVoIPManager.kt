package com.bradesco.bravoip.manager

import com.bradesco.bravoip.impl.avaya.di.braVoIPKoinMainModule
import com.bradesco.bravoip.impl.avaya.domain.usecases.AVITokenRequestUseCase
import com.bradesco.bravoip.impl.avaya.presentation.AVVoIPImpl
import com.bradesco.bravoip.interfaces.BRAIVoIP
import com.bradesco.bravoip.interfaces.BRAIVoIPEventListener
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

        fun getInstance(eventListener: BRAIVoIPEventListener): BRAVoIPManager {
            if (!::braVoIPStore.isInitialized) {
                getInstance()
            }
            braVoIPStore.setEventListener(eventListener)

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
                get(AVITokenRequestUseCase::class.java)
            )

            return INSTANCE
        }
    }
}