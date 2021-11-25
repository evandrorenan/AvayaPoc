package com.bradesco.bravoip.impl.avaya.presentation

import com.bradesco.bravoip.impl.avaya.domain.usecases.AVITokenRequestUseCase
import com.bradesco.bravoip.notarchitected.helpers.AVAuthorizationHandler
import com.bradesco.bravoip.notarchitected.helpers.AVPlatformPreferences
import com.bradesco.bravoip.interfaces.BRAIVoIP

internal class AVVoIPImpl(
    private val avTokenUseCase: AVITokenRequestUseCase
) : BRAIVoIP {

    private val voipPreferences = AVPlatformPreferences("urlRest", 8080)

    override fun requestToken(otp: String) {
        avTokenUseCase.execute()
    }

    private val authHandler: AVAuthorizationHandler by lazy {
        AVAuthorizationHandler(voipPreferences)
    }

    override fun startCall(token: String) {
        TODO("Not yet implemented")
    }

    override fun mute() {
        TODO("Not yet implemented")
    }

    override fun sendDTMF(digit: String) {
        TODO("Not yet implemented")
    }

    override fun hangUp() {
        TODO("Not yet implemented")
    }
}