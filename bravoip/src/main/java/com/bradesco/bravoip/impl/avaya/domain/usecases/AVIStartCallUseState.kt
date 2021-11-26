package com.bradesco.bravoip.impl.avaya.domain.usecases

import com.bradesco.bravoip.impl.avaya.domain.model.interfaces.AVIRepository
import com.bradesco.bravoip.impl.avaya.domain.usecases.base.AVResourceState
import com.bradesco.bravoip.interfaces.BRAIVoIPCall
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlin.coroutines.CoroutineContext

internal interface AVIStartCallUseCase {
    fun execute() : Flow<AVResourceState<BRAIVoIPCall>>
}

internal class AVStartCallUseCase(
    private val avRepository: AVIRepository,
) : AVIStartCallUseCase, CoroutineScope {

    private val useCaseJob = SupervisorJob()

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO + useCaseJob

    override fun execute() : Flow<AVResourceState<BRAIVoIPCall>> {

        return flow {

            emit(AVResourceState.Loading)

            val voIPCall = avRepository.startCall()
            voIPCall.start()

            emit(AVResourceState.Success(voIPCall))

        }.catch {
            it.message?.let { msg ->
                emit(AVResourceState.Error(msg))
            }
        }
    }
}