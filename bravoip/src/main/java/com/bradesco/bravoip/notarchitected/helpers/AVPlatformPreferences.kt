package com.bradesco.bravoip.notarchitected.helpers

data class AVPlatformPreferences (
    override val amcUrlPath: String,
    override val amcPort: Int,
    override val contextName: String = "",
    override val gatewayUrl: String = "",
    override val gatewayPort: String = ""
) : AVIPlatformPreferences