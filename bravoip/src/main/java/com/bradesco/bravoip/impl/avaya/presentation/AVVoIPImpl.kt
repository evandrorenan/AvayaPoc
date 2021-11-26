package com.bradesco.bravoip.impl.avaya.presentation

import com.bradesco.bravoip.impl.avaya.domain.usecases.AVIRequestTokenUseCase
import com.bradesco.bravoip.impl.avaya.domain.usecases.AVIStartCallUseCase
import com.bradesco.bravoip.impl.avaya.domain.usecases.base.AVResourceState
import com.bradesco.bravoip.interfaces.BRAIVoIP
import com.bradesco.bravoip.interfaces.BRAIVoIPCall
import com.bradesco.bravoip.interfaces.BRAIVoIPEventListener
import com.bradesco.bravoip.manager.BRAVoIPStore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.Flow
import kotlin.coroutines.CoroutineContext

internal class AVVoIPImpl(
    private val braVoIPStore: BRAVoIPStore,
    private val avRequestTokenUseCase: AVIRequestTokenUseCase,
    private val avStartCallUseCase: AVIStartCallUseCase
) : BRAIVoIP, CoroutineScope {

    private val useCaseJob = SupervisorJob()

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO + useCaseJob

    override fun requestToken() : Flow<AVResourceState<String>> {
        return avRequestTokenUseCase.execute()
    }

    override fun startCall(token: String, eventListener: BRAIVoIPEventListener): Flow<AVResourceState<BRAIVoIPCall>> {
        braVoIPStore.token = token
        braVoIPStore.eventListener = eventListener
        return avStartCallUseCase.execute()
    }
}