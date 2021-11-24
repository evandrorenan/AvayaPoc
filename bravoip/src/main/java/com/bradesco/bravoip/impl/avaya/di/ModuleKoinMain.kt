package com.bradesco.bravoip.impl.avaya.di

import android.content.Context
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

internal val braVoIPKoinModuleMain = module {
    single<Context>(override = true) {
        androidApplication()
    }
}