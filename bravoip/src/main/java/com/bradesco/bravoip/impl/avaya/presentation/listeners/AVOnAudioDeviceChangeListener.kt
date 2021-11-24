package com.bradesco.bravoip.impl.avaya.presentation.listeners

import com.avaya.ocs.Services.Work.Enums.AudioDeviceError
import com.avaya.ocs.Services.Work.Enums.AudioDeviceType
import com.avaya.ocs.Services.Work.Interactions.Listeners.OnAudioDeviceChangeListener

class AVOnAudioDeviceChangeListener : OnAudioDeviceChangeListener {
    override fun onAudioDeviceListChanged(p0: MutableList<AudioDeviceType>?) {
        TODO("Not yet implemented")
    }

    override fun onAudioDeviceChanged(p0: AudioDeviceType?) {
        TODO("Not yet implemented")
    }

    override fun onAudioDeviceError(p0: AudioDeviceError?) {
        TODO("Not yet implemented")
    }
}