package com.bradesco.bravoip.impl.avaya.domain.model.interfaces

import com.bradesco.bravoip.impl.avaya.domain.usecases.base.AVResourceState
import com.bradesco.bravoip.interfaces.BRAIVoIPCall
import kotlinx.coroutines.flow.Flow

interface AVIRepository {

    fun requestToken(): Flow<AVResourceState<String>>

    suspend fun startCall(): BRAIVoIPCall
}
