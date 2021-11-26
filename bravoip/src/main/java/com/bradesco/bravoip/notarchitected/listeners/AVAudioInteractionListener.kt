package com.bradesco.bravoip.notarchitected.listeners

import com.avaya.ocs.Services.Device.Video.Enums.CallQuality
import com.avaya.ocs.Services.Work.Enums.AudioDeviceError
import com.avaya.ocs.Services.Work.Enums.AudioDeviceType
import com.avaya.ocs.Services.Work.Enums.InteractionError
import com.avaya.ocs.Services.Work.Interactions.Listeners.AudioInteractionListener
import com.avaya.ocs.Services.Work.Interactions.Listeners.OnAudioDeviceChangeListener
import com.bradesco.bravoip.interfaces.BRAIVoIPEventListener

class AVVoIPCallListener  {

    override fun onInteractionInitiating() {
        TODO("Not yet implemented")
    }

    override fun onInteractionActive() {
        TODO("Not yet implemented")
    }

    override fun onInteractionEnded() {
        TODO("Not yet implemented")
    }

    override fun onInteractionHeld() {
        TODO("Not yet implemented")
    }

    override fun onInteractionUnheld() {
        TODO("Not yet implemented")
    }

    override fun onInteractionFailed(p0: InteractionError?) {
        TODO("Not yet implemented")
    }

    override fun onDiscardComplete() {
        TODO("Not yet implemented")
    }

    override fun onInteractionHeldRemotely() {
        TODO("Not yet implemented")
    }

    override fun onInteractionUnheldRemotely() {
        TODO("Not yet implemented")
    }

    override fun onInteractionRemoteAlerting() {
        TODO("Not yet implemented")
    }

    override fun onInteractionAudioMuteStatusChanged(p0: Boolean) {
        TODO("Not yet implemented")
    }

    override fun onInteractionQualityChanged(p0: CallQuality?) {
        TODO("Not yet implemented")
    }

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