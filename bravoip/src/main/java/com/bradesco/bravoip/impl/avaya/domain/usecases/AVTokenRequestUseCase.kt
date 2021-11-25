package com.bradesco.bravoip.impl.avaya.domain.usecases

import com.bradesco.bravoip.impl.avaya.domain.model.interfaces.AVIRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

internal interface AVITokenRequestUseCase {
    fun execute()
}

internal class AVTokenRequestUseCase(
    private val avRepository: AVIRepository
) : AVITokenRequestUseCase, CoroutineScope {

    private val useCaseJob = SupervisorJob()

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO + useCaseJob

    override fun execute() {
        launch {
            avRepository.requestToken().collect {}
        }
    }
}