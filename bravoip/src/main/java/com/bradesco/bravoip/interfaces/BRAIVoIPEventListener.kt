package com.bradesco.bravoip.interfaces

import com.avaya.callprovider.cp.handlers.OnAudioDeviceChangeListener
import com.avaya.ocs.Services.Work.Interactions.Listeners.AudioInteractionListener

interface BRAIVoIPEventListener : AudioInteractionListener, OnAudioDeviceChangeListener