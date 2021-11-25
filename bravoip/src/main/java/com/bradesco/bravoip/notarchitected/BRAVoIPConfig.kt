package com.bradesco.bravoip.notarchitected

import com.google.gson.annotations.SerializedName
import java.io.Serializable

internal class BRAVoIPConfig (
    @field:SerializedName("connection") var connection: BRAVoipCallWork
) : Serializable {

    class BRAVoipCallWork (
        @field:SerializedName("contextName")  var contextName: String,
        @field:SerializedName("platformName") var platformName: String,
        @field:SerializedName("client")       var client: BRAVoIPTokenRequest
    ) : Serializable {

        class BRAVoIPTokenRequest(
            @field:SerializedName("communicationServer") var communicationServer: BRAVoIPServer,
            @field:SerializedName("communicationServer") var gatewayServer: BRAVoIPServer
        ) : Serializable {

            class BRAVoIPServer(
                @field:SerializedName("Url")  var url: String,
                @field:SerializedName("port") var port: String
            ) : Serializable {}
        }
    }
}
