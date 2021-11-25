package com.bradesco.bravoip.impl.avaya.infrastructure.repository

import com.bradesco.bravoip.impl.avaya.domain.model.interfaces.AVIRepository
import com.bradesco.bravoip.impl.avaya.domain.usecases.base.AVResourceState
import com.bradesco.bravoip.impl.avaya.infrastructure.AVIProvider
import kotlinx.coroutines.flow.Flow

internal class AVRepository(
    private val avProvider: AVIProvider
) : AVIRepository {

    override fun requestToken() : Flow<AVResourceState<String>> {
        return avProvider.execLaunch()
    }
}