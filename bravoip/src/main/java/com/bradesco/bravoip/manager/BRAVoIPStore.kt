package com.bradesco.bravoip.manager

import android.app.Application
import com.bradesco.bravoip.interfaces.BRAIVoIPEventListener
import com.bradesco.bravoip.interfaces.BRAIVoIPParams
import java.lang.ref.WeakReference

internal class BRAVoIPStore {
    lateinit var eventListener: BRAIVoIPEventListener
    lateinit var voIPParams: BRAIVoIPParams
    lateinit var token: String
    lateinit var wrApplication: WeakReference<Application>

    fun getApplication(): Application? {
        return wrApplication.get()
    }

    fun setApplication(application: Application) {
        wrApplication = WeakReference(application)
    }
}