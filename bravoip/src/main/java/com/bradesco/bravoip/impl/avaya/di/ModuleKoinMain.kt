package com.bradesco.bravoip.impl.avaya.di

import com.bradesco.bravoip.impl.avaya.domain.model.interfaces.AVIRepository
import com.bradesco.bravoip.impl.avaya.domain.usecases.AVITokenRequestUseCase
import com.bradesco.bravoip.impl.avaya.domain.usecases.AVTokenRequestUseCase
import com.bradesco.bravoip.impl.avaya.infrastructure.AVIProvider
import com.bradesco.bravoip.impl.avaya.infrastructure.repository.AVRepository
import com.bradesco.bravoip.impl.avaya.presentation.AVVoIPImpl
import com.bradesco.bravoip.interfaces.BRAIVoIP
import org.koin.dsl.module
import com.bradesco.bravoip.impl.avaya.framework.AVProviderImpl

internal val braVoIPKoinMainModule = module {
    single<AVIProvider>(override = true) {
        AVProviderImpl(get())
    }

    single<AVIRepository>(override = true) {
        AVRepository(get())
    }

    single<AVITokenRequestUseCase>(override = true) {
        AVTokenRequestUseCase(get())
    }

    single<BRAIVoIP>(override = true) {
        AVVoIPImpl(get())
    }
}