package com.bradesco.bravoip.impl.avaya.domain.usecases

import com.bradesco.bravoip.impl.avaya.domain.model.interfaces.AVIRepository
import com.bradesco.bravoip.impl.avaya.domain.usecases.base.AVResourceState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

internal interface AVIRequestTokenUseCase {
    fun execute() : Flow<AVResourceState<String>>
}

internal class AVRequestTokenUseCase(
    private val avRepository: AVIRepository
) : AVIRequestTokenUseCase, CoroutineScope {

    private val useCaseJob = SupervisorJob()

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO + useCaseJob

    override fun execute() : Flow<AVResourceState<String>> {
        return avRepository.requestToken()
    }
}