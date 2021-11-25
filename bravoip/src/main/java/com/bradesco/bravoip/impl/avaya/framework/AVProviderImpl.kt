package com.bradesco.bravoip.impl.avaya.framework

import com.bradesco.bravoip.impl.avaya.domain.model.AVTokenRequest
import com.bradesco.bravoip.impl.avaya.domain.usecases.base.AVResourceState
import com.bradesco.bravoip.impl.avaya.infrastructure.AVIProvider
import com.bradesco.bravoip.impl.avaya.framework.retrofit.AVITokenService
import com.bradesco.bravoip.impl.avaya.framework.retrofit.AVVoipRetrofitBuilder
import com.bradesco.bravoip.manager.BRAVoIPStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.awaitResponse

internal class AVProviderImpl(
    private val braVoIPStore: BRAVoIPStore
) : AVIProvider {

    override fun execLaunch(): Flow<AVResourceState<String>> {

        val requestBody = AVTokenRequest(
            calledNumber = "calledNumber", callingNumber = "callingNumber", displayName = ""
        )
        val retrofitClient = AVVoipRetrofitBuilder.getRetrofitInstanceForTokenAuth("restUrl")
        val avTokenService = retrofitClient.create(AVITokenService::class.java)

        return flow {
            emit(AVResourceState.Loading)

            val request = avTokenService.getAuthToken(requestBody)

            try {
                val response = request.awaitResponse()
                if (!response.isSuccessful) {
                    emit(AVResourceState.Error(response.message()))
                }
                emit(AVResourceState.Success(response.body()?.encryptedToken ?: ""))
            } catch (e: Exception) {
                emit(AVResourceState.Error(e.message ?: e.toString()))
            }
        }
    }
}