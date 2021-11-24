package com.bradesco.bravoip.impl.avaya.infrastructure.repository

import com.avaya.ocs.Services.Work.Enums.PlatformType
import com.bradesco.bravoip.impl.avaya.domain.interfaces.BRAIVoipRepository
import com.bradesco.bravoip.impl.avaya.infrastructure.interfaces.BRAVoIPRemoteConfig
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

internal class BRAVoipRepository : BRAIVoipRepository {

    //TODO: PODE ACESSAR REMOTE CONFIG? DEPENDENCIA APPUNICO PARA FirebaseUtils e ResourceState

    override fun getVoipRemoteConfigPROBLEM(config: String): Flow<BRAVoIPRemoteConfig> {
        val communicationServer = BRAVoIPRemoteConfig.BRAVoipCallWork.BRAVoIPCallClient.BRAVoIPServer("restUrl", "port")
        val gatewayServer = BRAVoIPRemoteConfig.BRAVoipCallWork.BRAVoIPCallClient.BRAVoIPServer("restUrl", "port")

        val voipClient = BRAVoIPRemoteConfig.BRAVoipCallWork.BRAVoIPCallClient(communicationServer, gatewayServer)
        val work = BRAVoIPRemoteConfig.BRAVoipCallWork("contextName", PlatformType.OCEANA.toString(), voipClient)
        return flow {
            emit(BRAVoIPRemoteConfig(work))
        }
    }

    override fun getVoipRemoteConfig(config: String): BRAVoIPRemoteConfig {
        val communicationServer = BRAVoIPRemoteConfig.BRAVoipCallWork.BRAVoIPCallClient.BRAVoIPServer("restUrl", "port")
        val gatewayServer = BRAVoIPRemoteConfig.BRAVoipCallWork.BRAVoIPCallClient.BRAVoIPServer("restUrl", "port")

        val voipClient = BRAVoIPRemoteConfig.BRAVoipCallWork.BRAVoIPCallClient(communicationServer, gatewayServer)
        val work = BRAVoIPRemoteConfig.BRAVoipCallWork("contextName", PlatformType.OCEANA.toString(), voipClient)
        return BRAVoIPRemoteConfig(work)
    }
}