package com.example.otchallenge.di

import com.example.otchallenge.ui.bookslisting.BooksActivity
import com.example.otchallenge.di.module.ApplicationModule
import com.example.otchallenge.di.module.NetworkModule
import com.example.otchallenge.usecase.BooksUsecase
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, NetworkModule::class])
interface ApplicationComponent {
	fun inject(activity: BooksActivity)
	fun getBooksUseCase(): BooksUsecase
}
