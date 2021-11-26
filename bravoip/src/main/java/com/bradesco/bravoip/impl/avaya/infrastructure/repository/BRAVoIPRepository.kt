package com.bradesco.bravoip.impl.avaya.infrastructure.repository

import com.bradesco.bravoip.impl.avaya.domain.model.interfaces.AVIRepository
import com.bradesco.bravoip.impl.avaya.domain.usecases.base.AVResourceState
import com.bradesco.bravoip.impl.avaya.framework.AVStartCallProvider
import com.bradesco.bravoip.impl.avaya.infrastructure.AVIRequestTokenProvider
import com.bradesco.bravoip.interfaces.BRAIVoIPCall
import kotlinx.coroutines.flow.Flow

internal class AVRepository(
    private val avRequestTokenProvider: AVIRequestTokenProvider,
    private val avStartCallProvider: AVStartCallProvider
) : AVIRepository {

    override fun requestToken() : Flow<AVResourceState<String>> {
        return avRequestTokenProvider.launchRequestToken()
    }

    override suspend fun startCall(): BRAIVoIPCall {
        return avStartCallProvider.launchStartCall()
    }
}