package com.bradesco.bravoip.manager

import android.app.Activity
import com.bradesco.bravoip.impl.avaya.di.braVoIPKoinModuleMain
import com.bradesco.bravoip.impl.avaya.framework.AVActivityStore
import com.bradesco.bravoip.impl.avaya.presentation.AVVoIPImpl
import com.bradesco.bravoip.interfaces.BRAIVoIP
import org.koin.core.context.loadKoinModules

class BRAVoIPManager {

    fun getBRAVoIPImpl(): BRAIVoIP {
        return braVoIP
    }

    companion object {
        private lateinit var braVoIP: BRAIVoIP
        private lateinit var INSTANCE: BRAVoIPManager
        private lateinit var avActivityStore: AVActivityStore

        fun getInstance(activity: Activity): BRAVoIPManager {
            if (!::avActivityStore.isInitialized) {
                getInstance()
            }
            avActivityStore.setActivity(activity)
            return getInstance()
        }

        fun getInstance(): BRAVoIPManager {

            if (!this::INSTANCE.isInitialized) {
                loadKoinModules(
                    arrayListOf(braVoIPKoinModuleMain)
                )
            }

            INSTANCE = BRAVoIPManager()

            avActivityStore = AVActivityStore()
            braVoIP = AVVoIPImpl()
            return INSTANCE
        }
    }
}