package com.bradesco.bravoip.notarchitected.helpers

import com.bradesco.bravoip.impl.avaya.domain.model.interfaces.AVITokenResponse
import com.bradesco.bravoip.impl.avaya.domain.model.AVTokenRequest
import com.bradesco.bravoip.impl.avaya.framework.retrofit.AVITokenService
import com.bradesco.bravoip.impl.avaya.framework.retrofit.AVVoipRetrofitBuilder
import com.bradesco.bravoip.interfaces.BRAIVoIPEventListener
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

internal class AVAuthorizationHandler(val preferences: AVIPlatformPreferences) {

    suspend fun requestToken(eventListener: BRAIVoIPEventListener, cb: (String) -> Unit): Call<AVITokenResponse> {
        val requestBody = AVTokenRequest(
            calledNumber = "calledNumber", callingNumber = "callingNumber", displayName = "")

        val retrofitClient = AVVoipRetrofitBuilder.getRetrofitInstanceForTokenAuth("restUrl")
        val avTokenService = retrofitClient.create(AVITokenService::class.java)
        val callback = avTokenService.getAuthToken(requestBody)

        callback.enqueue(object : Callback<AVITokenResponse> {
            override fun onFailure(call: Call<AVITokenResponse>, t: Throwable) {
                print(t.message)
            }

            override fun onResponse(
                call: Call<AVITokenResponse>,
                response: Response<AVITokenResponse>
            ) {
                cb(response.body()?.encryptedToken ?: "")
            }
        })

        return callback
    }
}