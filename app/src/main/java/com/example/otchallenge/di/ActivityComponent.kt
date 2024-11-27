package com.example.otchallenge.di

import com.example.otchallenge.di.module.ActivityModule
import dagger.Subcomponent

@PerActivity
@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent {

}