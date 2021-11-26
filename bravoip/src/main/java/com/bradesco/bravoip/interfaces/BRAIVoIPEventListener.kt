package com.bradesco.bravoip.interfaces

import com.avaya.ocs.Services.Work.Enums.AudioDeviceError
import com.avaya.ocs.Services.Work.Interactions.Listeners.AudioInteractionListener
import com.avaya.ocs.Services.Work.Interactions.Listeners.OnAudioDeviceChangeListener

interface BRAIVoIPEventListener : AudioInteractionListener, OnAudioDeviceChangeListener {
    override fun onAudioDeviceError(p0: AudioDeviceError?) {
        TODO("Not yet implemented")
    }
}