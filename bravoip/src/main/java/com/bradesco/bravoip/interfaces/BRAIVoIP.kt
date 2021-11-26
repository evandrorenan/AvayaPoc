package com.bradesco.bravoip.interfaces

import com.bradesco.bravoip.impl.avaya.domain.usecases.base.AVResourceState
import kotlinx.coroutines.flow.Flow

interface BRAIVoIP {

    fun requestToken() : Flow<AVResourceState<String>>

    fun startCall(token: String, eventListener: BRAIVoIPEventListener) : Flow<AVResourceState<BRAIVoIPCall>>
}