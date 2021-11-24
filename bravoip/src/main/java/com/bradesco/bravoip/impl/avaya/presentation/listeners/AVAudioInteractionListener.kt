package com.bradesco.bravoip.impl.avaya.presentation.listeners

import com.avaya.ocs.Services.Device.Video.Enums.CallQuality
import com.avaya.ocs.Services.Work.Enums.InteractionError
import com.avaya.ocs.Services.Work.Interactions.Listeners.AudioInteractionListener

class AVAudioInteractionListener : AudioInteractionListener {
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
}