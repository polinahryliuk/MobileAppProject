package com.frenchflashcardsproject.data

import kotlinx.coroutines.flow.Flow

class FlashcardRepository(private val flashcardDao: FlashcardDao) {
    val allCards: Flow<List<Flashcard>> = flashcardDao.getAllCards()
    val totalCount: Flow<Int> = flashcardDao.getTotalCount()
    val masteredCount: Flow<Int> = flashcardDao.getMasteredCount()
    val unmasteredCards: Flow<List<Flashcard>> = flashcardDao.getUnmasteredCards()

    suspend fun insert(card: Flashcard) = flashcardDao.insert(card)
    suspend fun update(card: Flashcard) = flashcardDao.update(card)
    suspend fun delete(card: Flashcard) = flashcardDao.delete(card)
}