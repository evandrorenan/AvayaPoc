package com.bradesco.bravoip.interfaces

interface BRAIVoIPCallEventListener {

    fun onReadyToCall()

    fun onCallInitiating()

    fun onCallActive()

    fun onCallAudioMuteStatusChanged(muted: Boolean)

    fun onCallFailed(error: BRAIVoIPCallError)
}