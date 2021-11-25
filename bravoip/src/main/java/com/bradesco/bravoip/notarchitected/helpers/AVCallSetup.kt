package com.bradesco.bravoip.notarchitected.helpers

import android.app.Application
import com.avaya.ocs.Config.ClientConfiguration
import com.avaya.ocs.Config.Config
import com.avaya.ocs.Config.WebGatewayConfiguration
import com.avaya.ocs.OceanaCustomerWebVoiceVideo
import com.avaya.ocs.Services.Work.Enums.PlatformType
import com.avaya.ocs.Services.Work.Interactions.AudioInteraction
import com.avaya.ocs.Services.Work.Interactions.Listeners.AudioInteractionListener
import com.avaya.ocs.Services.Work.Interactions.Listeners.OnAudioDeviceChangeListener
import com.avaya.ocs.Services.Work.Schema.Attributes
import com.avaya.ocs.Services.Work.Schema.Resource
import com.avaya.ocs.Services.Work.Schema.Service
import com.avaya.ocs.Services.Work.Work
import com.bradesco.bravoip.notarchitected.BRAVoIPConfig
import com.bradesco.bravoip.notarchitected.listeners.AVAudioInteractionListener
import com.bradesco.bravoip.notarchitected.listeners.AVOnAudioDeviceChangeListener

internal class AVCallSetup(
    private val braVoIPRemoteConfig: BRAVoIPConfig,
    private val context: Application
) {
    
    fun setupCall() {
        val token = "" // response.body.encryptedToken
        val client = setupOceanaCustomerClient()
        val services = setupClientServices()
        val resources = setupClientResources()
        val work = setupOceanaWork(client, services, resources)
        val audioInteraction = setupAudioInteraction(work)
        audioInteraction.authorizationToken = token
        audioInteraction.start()

    }

    private fun setupOceanaCustomerClient(): OceanaCustomerWebVoiceVideo {
        val generalConfigs = getRestConfigs()
        val clientConfig = setupClientConfigs(generalConfigs)
        setupWebGatewayConfigs(clientConfig)

        val client = OceanaCustomerWebVoiceVideo(clientConfig)
        return client
    }

    private fun setupClientServices(): ArrayList<Service> {
        val services = ArrayList<Service>()

        val service = Service()

        //Used do route to an agent capable of dealing with some specific subject
        service.attributes = Attributes();
        service.priority = 5

        services.add(service)
        return services
    }

    private fun setupClientResources(): ArrayList<Resource> {
        val resources = ArrayList<Resource>()

        val resource = Resource()
        resource.nativeResourceId = "agent6220"
        resource.sourceName = "CM"

        resources.add(resource)
        return resources
    }

    private fun setupOceanaWork(
        client: OceanaCustomerWebVoiceVideo,
        services: ArrayList<Service>,
        resources: ArrayList<Resource>
    ): Work {
        val work = client.createWork()
        work.services = services
        work.resources = resources
        work.context = "String de contexto opcional"
        return work
    }

    private fun setupAudioInteraction(work: Work): AudioInteraction {
        val audioInteraction = work.createAudioInteraction(
            context.applicationContext as Application,
            newAudioDeviceChangeListener()
        )
        audioInteraction.platformType = PlatformType.OCEANA
        audioInteraction.registerListener(newAudioInteractionListener())
        audioInteraction.destinationAddress = "destinationAddres"
        return audioInteraction
    }

    private fun newAudioDeviceChangeListener(): OnAudioDeviceChangeListener {
        return AVOnAudioDeviceChangeListener()
    }

    private fun newAudioInteractionListener(): AudioInteractionListener {
        return AVAudioInteractionListener()
    }

    private fun setupWebGatewayConfigs(clientConfig: ClientConfiguration) {
        val webGatewayConfig = WebGatewayConfiguration()
        webGatewayConfig.webGatewayAddress = "aawg-fqdn"
        webGatewayConfig.port = 8443
        webGatewayConfig.isSecure = true
        clientConfig.webGatewayConfiguration = webGatewayConfig
    }

    private fun setupClientConfigs(generalConfigs: Config): ClientConfiguration {
        val clientConfig = ClientConfiguration()
        return clientConfig
    }

    private fun getRestConfigs(): Config {
        val generalConfigs = Config("restUrl")
        generalConfigs.port = 80
        generalConfigs.isSecure = true
        return generalConfigs
    }
}