package com.example.avayapoc

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bradesco.bravoip.interfaces.BRAIVoIPEventListener
import com.bradesco.bravoip.interfaces.BRAIVoIPParams
import com.bradesco.bravoip.manager.BRAVoIPManager
import com.example.avayapoc.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        BRAVoIPManager.Companion.getInstance(requireActivity().application, object : BRAIVoIPParams {
            override val context: String
                get() = TODO("Not yet implemented")
            override val locale: String?
                get() = TODO("Not yet implemented")
            override val topic: String?
                get() = TODO("Not yet implemented")
            override val routingStrategy: String?
                get() = TODO("Not yet implemented")
            override val destinationAddress: String?
                get() = TODO("Not yet implemented")
            override val tokenSeverUrlBase: String
                get() = TODO("Not yet implemented")
            override val tokenRequestEndpoint: String
                get() = TODO("Not yet implemented")
            override val tokenServerPort: String
                get() = TODO("Not yet implemented")
            override val tokenRequestContentType: String
                get() = TODO("Not yet implemented")
            override val tokenRequest: BRAIVoIPParams.BRAITokenRequest
                get() = TODO("Not yet implemented")
            override val gatewayServerUrl: String
                get() = TODO("Not yet implemented")
            override val gatewayPortUrl: Int
                get() = TODO("Not yet implemented")
            override val gatewayEndpoint: String
                get() = TODO("Not yet implemented")
        },
        object : BRAIVoIPEventListener {
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

            override fun onInteractionFailed(p0: com.avaya.ocs.Services.Work.Enums.InteractionError?) {
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

            override fun onInteractionQualityChanged(p0: com.avaya.ocs.Services.Device.Video.Enums.CallQuality?) {
                TODO("Not yet implemented")
            }

            override fun onAudioDeviceListChanged(p0: MutableList<com.avaya.ocs.Services.Work.Enums.AudioDeviceType>?) {
                TODO("Not yet implemented")
            }

            override fun onAudioDeviceChanged(p0: com.avaya.ocs.Services.Work.Enums.AudioDeviceType?) {
                TODO("Not yet implemented")
            }

            override fun onAudioDeviceError(p0: com.avaya.ocs.Services.Work.Enums.AudioDeviceError?) {
                TODO("Not yet implemented")
            }
        }).getBRAVoIPImpl()

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}