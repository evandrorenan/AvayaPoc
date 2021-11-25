package com.bradesco.bravoip.manager

import android.app.Activity
import com.bradesco.bravoip.interfaces.BRAIVoIPEventListener
import java.lang.ref.WeakReference

internal class BRAVoIPStore {
    lateinit var wrEventListener: WeakReference<BRAIVoIPEventListener>
    lateinit var weakReference: WeakReference<Activity>

    fun getActivity() : Activity? {
        return weakReference.get()
    }

    fun setActivity(activity: Activity) {
        weakReference = WeakReference(activity)
    }

    fun getEventListener() : BRAIVoIPEventListener? {
        return wrEventListener.get()
    }

    fun setEventListener(eventListener: BRAIVoIPEventListener) {
        wrEventListener = WeakReference(eventListener)
    }
}