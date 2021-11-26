package com.bradesco.bravoip.impl.avaya.framework

import com.avaya.ocs.Config.ClientConfiguration
import com.avaya.ocs.Config.WebGatewayConfiguration
import com.avaya.ocs.OceanaCustomerWebVoiceVideo
import com.avaya.ocs.Services.Work.Enums.PlatformType
import com.avaya.ocs.Services.Work.Interactions.AudioInteraction
import com.avaya.ocs.Services.Work.Work
import com.bradesco.bravoip.impl.avaya.infrastructure.AVIStartCallProvider
import com.bradesco.bravoip.interfaces.BRAIVoIPCall
import com.bradesco.bravoip.interfaces.BRAIVoIPParams
import com.bradesco.bravoip.manager.BRAVoIPStore

internal class AVStartCallProvider(
    private val braVoIPStore: BRAVoIPStore
) : AVIStartCallProvider {
    override suspend fun launchStartCall(): BRAIVoIPCall {
        val client = setupOceanaClient()
        val work = setupOceanaWork(client)
        return setupAudioInteraction(work) as BRAIVoIPCall
    }

    private fun setupOceanaWork(client: OceanaCustomerWebVoiceVideo): Work {
        val work = client.createWork()
        work.context = getParams().context

        getParams().locale?.let { work.locale = it}
        getParams().topic?.let { work.topic = it}
        getParams().routingStrategy?.let { work.routingStrategy = it }

        return work
    }

    private fun setupAudioInteraction(work: Work): AudioInteraction {
        val audioInteraction = work.createAudioInteraction(braVoIPStore.getApplication(), braVoIPStore.eventListener)
        audioInteraction.platformType = PlatformType.ELITE
        audioInteraction.registerListener(braVoIPStore.eventListener)
        audioInteraction.context = getParams().context
        audioInteraction.authorizationToken = braVoIPStore.token
        getParams().destinationAddress?.let { audioInteraction.destinationAddress = it}
        return audioInteraction
    }

    private fun setupOceanaClient(): OceanaCustomerWebVoiceVideo {
        val clientConfig = setupClientConfiguration(ClientConfiguration())
        clientConfig.webGatewayConfiguration = setupWebGatewayConfigs(WebGatewayConfiguration())
        return OceanaCustomerWebVoiceVideo(clientConfig)
    }

    private fun setupClientConfiguration(clientConfig: ClientConfiguration): ClientConfiguration {
        clientConfig.webGatewayConfiguration = setupWebGatewayConfigs(WebGatewayConfiguration())
        return clientConfig
    }

    private fun setupWebGatewayConfigs(webGatewayConfig: WebGatewayConfiguration): WebGatewayConfiguration {
        webGatewayConfig.webGatewayAddress = getParams().gatewayServerUrl
        webGatewayConfig.port = getParams().gatewayPortUrl
        webGatewayConfig.isSecure = true
        webGatewayConfig.webGatewayUrlPath = getParams().gatewayEndpoint
        return webGatewayConfig
    }

    private fun getParams(): BRAIVoIPParams {
        return braVoIPStore.voIPParams
    }
}

