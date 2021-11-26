package com.bradesco.bravoip.impl.avaya.framework.retrofit

import com.bradesco.bravoip.impl.avaya.domain.model.interfaces.AVITokenRequest
import com.bradesco.bravoip.impl.avaya.domain.model.interfaces.AVITokenResponse
import retrofit2.Call
import retrofit2.http.*

internal interface AVITokenService {
    @POST("csa/resources/tokens")  //TODO: Make this dynamic from caller
    suspend fun getAuthToken(
        @Header("Content-Type") contentType: String,
        @Body request: AVITokenRequest) : Call<AVITokenResponse>
}