package com.bradesco.bravoip.interfaces

interface BRAIVoIPEventListener {

    fun onAuthTokenGenerated(token: String)

    fun onCallInitiating()

    fun onCallActive()

    fun onCallAudioMuteStatusChanged(muted: Boolean)
}