package com.bradesco.bravoip.interfaces

interface BRAIVoIP {

    fun requestToken(otp: String)

    fun startCall(token: String)

    fun mute()

    fun sendDTMF(digit: String)

    fun hangUp()
}