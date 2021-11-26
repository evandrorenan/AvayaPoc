package com.bradesco.bravoip.impl.avaya.presentation

import com.avaya.ocs.Services.Work.Enums.DTMFTone
import com.avaya.ocs.Services.Work.Interactions.AudioInteraction
import com.bradesco.bravoip.interfaces.BRAIVoIPCall
import com.bradesco.bravoip.interfaces.BRAIVoIPEventListener

class AVVoIPCall(private val interaction: AudioInteraction) : BRAIVoIPCall {

    private val eventListeners = mutableListOf<BRAIVoIPEventListener>()

    override fun registerListener(eventListener: BRAIVoIPEventListener) {
        this.eventListeners.add(eventListener)
    }

    override fun muteAudio(mute: Boolean) {
        this.interaction.muteAudio(mute)
    }

    override fun sendDTMF(key: String) {
        this.interaction.sendDtmf(DTMFTone.get(key))
    }

    override fun hangUp() {
        this.interaction.end()
    }
}