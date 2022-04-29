package com.zlsp.tablecpfc.present

import android.app.Application
import com.zlsp.tablecpfc.present.di.AppComponent
import com.zlsp.tablecpfc.present.di.AppModule
import com.zlsp.tablecpfc.present.di.DaggerAppComponent
import javax.inject.Inject

class App: Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .build()
    }
}