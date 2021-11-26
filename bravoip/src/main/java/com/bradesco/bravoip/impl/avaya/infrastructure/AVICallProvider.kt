package com.bradesco.bravoip.impl.avaya.infrastructure

import com.bradesco.bravoip.impl.avaya.domain.usecases.base.AVResourceState
import kotlinx.coroutines.flow.Flow

interface AVICallProvider {
    fun launchStarCall(): Flow<AVResourceState<Unit>>
}
