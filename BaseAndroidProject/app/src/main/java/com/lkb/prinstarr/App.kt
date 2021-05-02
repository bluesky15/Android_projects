package com.lkb.prinstarr

import android.app.Application
import com.lkb.prinstarr.di.appModule
import com.lkb.prinstarr.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        // Start Koin
        startKoin{
            androidLogger()
            androidContext(this@App)
            modules(appModule, networkModule)
        }
    }


}