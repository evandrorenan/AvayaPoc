package com.bradesco.bravoip.impl.avaya.framework.retrofit

import com.bradesco.bravoip.impl.avaya.domain.model.interfaces.AVITokenRequest
import com.bradesco.bravoip.impl.avaya.domain.model.interfaces.AVITokenResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

internal interface AVITokenService {
    @Headers("Content-Type: application/vnd.avaya.csa.tokens.v1+json")
    @POST("csa/resources/tokens")
    suspend fun getAuthToken(@Body request: AVITokenRequest) : Call<AVITokenResponse>
}