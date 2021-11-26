package com.bradesco.bravoip.impl.avaya.infrastructure

import com.bradesco.bravoip.impl.avaya.domain.usecases.base.AVResourceState
import kotlinx.coroutines.flow.Flow

interface AVIRequestTokenProvider {
    fun launchRequestToken(): Flow<AVResourceState<String>>
}
