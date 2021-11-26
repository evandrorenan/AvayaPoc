package com.bradesco.bravoip.interfaces

interface BRAIVoIPParams {

    val context: String
    val locale: String?
    val topic: String?
    val routingStrategy: String?
    val destinationAddress: String?

    val tokenSeverUrlBase: String
    val tokenRequestEndpoint: String
    val tokenServerPort: String
    val tokenRequestContentType: String
    val tokenRequest : BRAITokenRequest

    val gatewayServerUrl: String
    val gatewayPortUrl: Int
    val gatewayEndpoint: String

    interface BRAITokenRequest {
        val use : String
        val calledNumber: String?
        val callingNumber: String?
        val displayName: String?
        val expiration: String
    }
}