package com.bradesco.bravoip.impl.avaya.framework

import com.bradesco.bravoip.impl.avaya.domain.model.AVTokenRequest
import com.bradesco.bravoip.impl.avaya.domain.usecases.base.AVResourceState
import com.bradesco.bravoip.impl.avaya.infrastructure.AVIRequestTokenProvider
import com.bradesco.bravoip.impl.avaya.framework.retrofit.AVITokenService
import com.bradesco.bravoip.impl.avaya.framework.retrofit.AVVoipRetrofitBuilder
import com.bradesco.bravoip.manager.BRAVoIPStore
import kotlinx.coroutines.flow.Flow
import com.bradesco.bravoip.impl.avaya.domain.model.interfaces.AVITokenRequest
import kotlinx.coroutines.flow.flow
import retrofit2.Retrofit
import retrofit2.awaitResponse

internal class AVRequestTokenProvider(
    private val braVoIPStore: BRAVoIPStore
) : AVIRequestTokenProvider {

    override fun launchRequestToken(): Flow<AVResourceState<String>> {

        val requestBody = buildTokenRequestBody()

        val retrofitClient = buildRetrofitClient()

        val avTokenService = retrofitClient.create(AVITokenService::class.java)

        return flow {
            emit(AVResourceState.Loading)

            val request = avTokenService.getAuthToken(
                braVoIPStore.voIPParams.tokenRequestContentType,
                requestBody)

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

    private fun buildRetrofitClient(): Retrofit {
        val server = braVoIPStore.voIPParams.tokenSeverUrlBase
        val port = braVoIPStore.voIPParams.tokenServerPort

        val retrofitClient = AVVoipRetrofitBuilder.getRetrofitInstanceForTokenAuth(
            "http://$server/$port"
        )
        return retrofitClient
    }

    private fun buildTokenRequestBody(): AVITokenRequest {
        val token = braVoIPStore.voIPParams.tokenRequest
        return AVTokenRequest(
            token.use,
            token.calledNumber,
            token.callingNumber,
            token.displayName,
            token.expiration
        )
    }
}