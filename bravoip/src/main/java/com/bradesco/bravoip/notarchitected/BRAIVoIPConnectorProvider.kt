package com.bradesco.bravoip.notarchitected

import com.bradesco.bravoip.interfaces.BRAIVoIP
import com.bradesco.bravoip.interfaces.BRAIVoIPEventListener

interface BRAIVoIPConnectorProvider {
    fun getBRAVoIPImpl(eventListener: BRAIVoIPEventListener): BRAIVoIP
}