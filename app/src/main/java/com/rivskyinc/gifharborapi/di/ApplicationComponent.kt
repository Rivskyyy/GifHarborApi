package com.rivskyinc.gifharborapi.di

import android.app.Application
import com.rivskyinc.gifharborapi.presentation.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(modules = [AppModule::class])
@Singleton
interface ApplicationComponent {


    fun inject( activity  : MainActivity)

    @Component.Factory
    interface Factory {

        fun create (
            @BindsInstance application : Application
        ) : ApplicationComponent
    }

}