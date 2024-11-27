package com.example.otchallenge.di.module

import android.app.Activity
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Inject

@Module
class ActivityModule @Inject constructor(private val activity: Activity) {
    @Provides
    fun provideActivity(): Activity {
        return activity
    }

    @Provides
    fun providesContext(): Context {
        return activity
    }
}
