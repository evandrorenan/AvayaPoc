package com.bradesco.bravoip.impl.avaya.domain.model

import com.bradesco.bravoip.impl.avaya.domain.model.interfaces.AVITokenRequest

internal data class AVTokenRequest(
    override val use: String = "csaGuest",
    override val calledNumber: String,
    override val callingNumber: String,
    override val displayName: String,
    override val expiration: String = "120000"
) : AVITokenRequest {}