package com.bradesco.bravoip.notarchitected.helpers

import com.avaya.ocs.Services.Work.Enums.PlatformType

const val TYPE_OCEANA = "OCEANA"
const val TYPE_ELITE = "ELITE"

internal abstract class AVAbstractVoIPSettings() {

    abstract fun retrievePreferences() : AVIPlatformPreferences

    abstract fun getType() : PlatformType
}
