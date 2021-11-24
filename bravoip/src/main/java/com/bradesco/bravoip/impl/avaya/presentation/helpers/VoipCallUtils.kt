package com.bradesco.bravoip.impl.avaya.presentation.helpers

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

class VoipCallUtils {
    
    companion object {
        fun setupOceanaCustomerClient(): OceanaCustomerWebVoiceVideo {
            val generalConfigs = getRestConfigs()
            val clientConfig = setupClientConfigs(generalConfigs)
            setupWebGatewayConfigs(clientConfig)

            val client = OceanaCustomerWebVoiceVideo(clientConfig)
            return client
        }

        fun setupClientServices(): ArrayList<Service> {
            val services = ArrayList<Service>()

            val service = Service()

            //Used do route to an agent capable of dealing with some specific subject
            service.attributes = Attributes();
            service.priority = 5

            services.add(service)
            return services
        }

        fun setupClientResources(): ArrayList<Resource> {
            val resources = ArrayList<Resource>()

            val resource = Resource()
            resource.nativeResourceId = "agent6220"
            resource.sourceName = "CM"

            resources.add(resource)
            return resources
        }

        fun setupOceanaWork(
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

        fun setupAudioInteraction(work: Work): AudioInteraction {
            val audioInteraction = work.createAudioInteraction(
                context.applicationContext as Application,
                newAudioDeviceChangeListener()
            )
            audioInteraction.platformType = PlatformType.OCEANA
            audioInteraction.registerListener(newAudioInteractionListener())
            audioInteraction.destinationAddress = "destinationAddres"
            return audioInteraction
        }

        fun newAudioDeviceChangeListener(): OnAudioDeviceChangeListener {
            return object : OnAudioDeviceChangeListener {
                override fun onAudioDeviceListChanged(p0: MutableList<AudioDeviceType>?) {
                    TODO("Not yet implemented")
                }

                override fun onAudioDeviceChanged(p0: AudioDeviceType?) {
                    TODO("Not yet implemented")
                }

                override fun onAudioDeviceError(p0: AudioDeviceError?) {
                    TODO("Not yet implemented")
                }
            }
        }

        fun newAudioInteractionListener(): AudioInteractionListener {
            return object : AudioInteractionListener {
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
        }

        fun setupWebGatewayConfigs(clientConfig: ClientConfiguration) {
            val webGatewayConfig = WebGatewayConfiguration()
            webGatewayConfig.webGatewayAddress = "aawg-fqdn"
            webGatewayConfig.port = 8443
            webGatewayConfig.isSecure = true
            clientConfig.webGatewayConfiguration = webGatewayConfig
        }

        fun setupClientConfigs(generalConfigs: Config): ClientConfiguration {
            val clientConfig = ClientConfiguration()
            return clientConfig
        }

        fun getRestConfigs(): Config {
            val generalConfigs = Config("restUrl")
            generalConfigs.port = 80
            generalConfigs.isSecure = true
            return generalConfigs
        }
    }

}