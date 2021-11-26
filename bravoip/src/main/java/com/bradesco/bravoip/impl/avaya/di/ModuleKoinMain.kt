package com.bradesco.bravoip.impl.avaya.di

import com.bradesco.bravoip.impl.avaya.domain.model.interfaces.AVIRepository
import com.bradesco.bravoip.impl.avaya.domain.usecases.AVIRequestTokenUseCase
import com.bradesco.bravoip.impl.avaya.domain.usecases.AVIStartCallUseCase
import com.bradesco.bravoip.impl.avaya.domain.usecases.AVRequestTokenUseCase
import com.bradesco.bravoip.impl.avaya.domain.usecases.AVStartCallUseCase
import com.bradesco.bravoip.impl.avaya.infrastructure.AVIRequestTokenProvider
import com.bradesco.bravoip.impl.avaya.infrastructure.repository.AVRepository
import com.bradesco.bravoip.impl.avaya.presentation.AVVoIPImpl
import com.bradesco.bravoip.interfaces.BRAIVoIP
import org.koin.dsl.module
import com.bradesco.bravoip.impl.avaya.framework.AVRequestTokenProvider
import com.bradesco.bravoip.impl.avaya.framework.AVStartCallProvider
import com.bradesco.bravoip.impl.avaya.infrastructure.AVIStartCallProvider
import com.bradesco.bravoip.manager.BRAVoIPStore

internal val braVoIPKoinMainModule = module {
    single<AVIStartCallProvider>(override = true) {
        AVStartCallProvider(get())
    }

    single<AVIRequestTokenProvider>(override = true) {
        AVRequestTokenProvider(get())
    }

    single<AVIRepository>(override = true) {
        AVRepository(get(), get())
    }

    single<AVIStartCallUseCase>(override = true) {
        AVStartCallUseCase(get())
    }

    single<AVIRequestTokenUseCase>(override = true) {
        AVRequestTokenUseCase(get())
    }

    single(override = true) {
        BRAVoIPStore()
    }

    single<BRAIVoIP>(override = true) {
        AVVoIPImpl(get(), get(), get())
    }
}