package com.bradesco.bravoip.notarchitected.helpers

import com.avaya.ocs.Services.Work.Enums.PlatformType

internal class AVVoIPSettings : AVAbstractVoIPSettings() {
    override fun retrievePreferences(): AVIPlatformPreferences {
        return AVPlatformPreferences("restUrl", 8080)
    }

    override fun getType(): PlatformType {
        return PlatformType.ELITE
    }
}