package com.rivskyinc.gifharborapi.presentation

import android.app.Application
import com.rivskyinc.gifharborapi.di.DaggerApplicationComponent


class GifApplication : Application() {

    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }
}