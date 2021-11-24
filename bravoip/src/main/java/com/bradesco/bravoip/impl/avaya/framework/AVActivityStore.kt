package com.bradesco.bravoip.impl.avaya.framework

import android.app.Activity
import java.lang.ref.WeakReference

internal class AVActivityStore {
    lateinit var weakReference: WeakReference<Activity>

    fun getActivity() : Activity? {
        return weakReference.get()
    }

    fun setActivity(activity: Activity) {
        weakReference = WeakReference(activity)
    }
}