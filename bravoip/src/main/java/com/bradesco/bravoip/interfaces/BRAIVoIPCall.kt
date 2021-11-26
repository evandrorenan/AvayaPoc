package com.bradesco.bravoip.interfaces

import com.avaya.ocs.Services.Work.Interactions.Interaction

interface BRAIVoIPCall : Interaction  {
    fun registerListener(eventListener: BRAIVoIPEventListener)

    fun muteAudio(mute: Boolean)

    fun sendDTMF(key: String)

    fun hangUp()
}