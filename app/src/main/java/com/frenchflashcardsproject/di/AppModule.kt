package com.frenchflashcardsproject.di

import android.content.Context
import com.frenchflashcardsproject.data.FlashcardDatabase
import com.frenchflashcardsproject.data.FlashcardRepository
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.InstallIn
//import dagger.hilt.android.qualifiers.ApplicationContext
//import dagger.hilt.components.SingletonComponent

/*@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideFlashcardDatabase(@ApplicationContext context: Context) =
        FlashcardDatabase.getDatabase(context)

    @Singleton
    @Provides
    fun provideFlashcardDao(database: FlashcardDatabase) =
        database.flashcardDao()

    @Singleton
    @Provides
    fun provideFlashcardRepository(dao: FlashcardDatabase.FlashcardDao) =
        FlashcardRepository(dao)
}*/