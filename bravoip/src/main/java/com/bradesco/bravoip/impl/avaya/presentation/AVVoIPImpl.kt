package com.bradesco.bravoip.impl.avaya.presentation

import android.app.Application
import com.avaya.ocs.Config.ClientConfiguration
import com.avaya.ocs.Config.Config
import com.avaya.ocs.Config.WebGatewayConfiguration
import com.avaya.ocs.OceanaCustomerWebVoiceVideo
import com.avaya.ocs.Services.Device.Video.Enums.CallQuality
import com.avaya.ocs.Services.Work.Enums.AudioDeviceError
import com.avaya.ocs.Services.Work.Enums.AudioDeviceType
import com.avaya.ocs.Services.Work.Enums.InteractionError
import com.avaya.ocs.Services.Work.Enums.PlatformType
import com.avaya.ocs.Services.Work.Interactions.AudioInteraction
import com.avaya.ocs.Services.Work.Interactions.Listeners.AudioInteractionListener
import com.avaya.ocs.Services.Work.Interactions.Listeners.OnAudioDeviceChangeListener
import com.avaya.ocs.Services.Work.Schema.Attributes
import com.avaya.ocs.Services.Work.Schema.Resource
import com.avaya.ocs.Services.Work.Schema.Service
import com.avaya.ocs.Services.Work.Work
import com.bradesco.bravoip.interfaces.BRAIVoIP
import com.bradesco.bravoip.interfaces.BRAIVoIPCallEventListener

internal class AVVoIPImpl : BRAIVoIP {

    lateinit var eventListener : BRAIVoIPCallEventListener

    override fun initConfig(otp: String) {

        val token = "" // response.body.encryptedToken
        val client = setupOceanaCustomerClient()
        val services = setupClientServices()
        val resources = setupClientResources()
        val work = setupOceanaWork(client, services, resources)
        val audioInteraction = setupAudioInteraction(work)
        audioInteraction.authorizationToken = token
        audioInteraction.start()
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

    private fun generateToken(otp: String): String {
//        url = https://<AAWGSERVER_ADDRESS>/csa/resources/tokens
//        contentType = application/vnd.avaya.csa.tokens.v1+json
//        POST BODY :
//            {
//                "use": "csaGuest",
//                "calledNumber": "xxxx"
//                "callingNumber": "xxxx"
//                "displayName": "xxx"
//                "expiration": 20000
//            }
//        RESPONSE BODY:
//            {
//                “encryptedToken” = <string>
//            }
        return ""
    }
}