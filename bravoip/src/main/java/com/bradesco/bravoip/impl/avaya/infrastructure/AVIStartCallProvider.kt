package com.bradesco.bravoip.impl.avaya.infrastructure

import com.bradesco.bravoip.interfaces.BRAIVoIPCall

interface AVIStartCallProvider {
    suspend fun launchStartCall(): BRAIVoIPCall
}