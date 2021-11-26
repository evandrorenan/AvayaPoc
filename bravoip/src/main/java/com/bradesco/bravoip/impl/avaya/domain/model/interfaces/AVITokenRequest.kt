package com.bradesco.bravoip.impl.avaya.domain.model.interfaces

interface AVITokenRequest {
    val use : String
    val calledNumber: String?
    val callingNumber: String?
    val displayName: String?
    val expiration: String
}