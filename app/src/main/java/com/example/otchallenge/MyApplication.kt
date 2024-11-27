package com.example.otchallenge

import android.app.Application
import com.example.otchallenge.di.ApplicationComponent
import com.example.otchallenge.di.DaggerApplicationComponent
import com.example.otchallenge.di.module.ApplicationModule

class MyApplication : Application() {

	lateinit var applicationComponent: ApplicationComponent

	override fun onCreate() {
		super.onCreate()
		applicationComponent = DaggerApplicationComponent
			.builder()
			.applicationModule(ApplicationModule(this))
			.build()
	}
}
