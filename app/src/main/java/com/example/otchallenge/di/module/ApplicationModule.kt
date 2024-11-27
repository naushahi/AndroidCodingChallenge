package com.example.otchallenge.di.module

import android.app.Application
import android.content.Context
import com.example.otchallenge.data.remote.ApiService
import com.example.otchallenge.repository.BooksRepository
import com.example.otchallenge.repository.BooksRepositoryImpl
import com.example.otchallenge.usecase.BooksUsecase
import dagger.Module
import dagger.Provides
import javax.inject.Inject
import javax.inject.Singleton

@Module
class ApplicationModule @Inject constructor(private val application: Application) {

    @Provides
    fun provideApplication(): Application {
        return application
    }

    @Provides
    fun provideContext(): Context {
        return application
    }

    @Provides
    @Singleton
    fun provideBooksRepository(apiService: ApiService): BooksRepository {
        return BooksRepositoryImpl(apiService)
    }

    @Provides
    @Singleton
    fun provideGetBooksUseCase(booksRepository: BooksRepository): BooksUsecase {
        return BooksUsecase(booksRepository)
    }
}