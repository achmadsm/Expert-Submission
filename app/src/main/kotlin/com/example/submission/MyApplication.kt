package com.example.submission

import android.app.Application
import com.example.submission.core.di.databaseModule
import com.example.submission.core.di.networkModule
import com.example.submission.core.di.repositoryModule
import com.example.submission.di.useCaseModule
import com.example.submission.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MyApplication)
            modules(
                listOf(
                    databaseModule,
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}