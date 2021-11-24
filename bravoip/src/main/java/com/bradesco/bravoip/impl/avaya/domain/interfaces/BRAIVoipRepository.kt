package com.bradesco.bravoip.impl.avaya.domain.interfaces

import com.bradesco.bravoip.impl.avaya.infrastructure.interfaces.BRAVoIPRemoteConfig
import kotlinx.coroutines.flow.Flow

internal interface BRAIVoipRepository {
    fun getVoipRemoteConfigPROBLEM(config: String) : Flow<BRAVoIPRemoteConfig> // Flow<ResourceState<BRAVoipRemoteConfig>> // Dependencia app Unico

    fun getVoipRemoteConfig(config: String) : BRAVoIPRemoteConfig
}