package com.zlsp.tablecpfc.present.di

import com.zlsp.tablecpfc.present.MainActivity
import dagger.Component

@Component(modules = [AppModule::class, DataModule::class, DomainModule::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity)
}