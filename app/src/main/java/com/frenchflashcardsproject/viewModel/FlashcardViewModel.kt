package com.frenchflashcardsproject.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.frenchflashcardsproject.data.Flashcard
import com.frenchflashcardsproject.data.FlashcardRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

data class FlashcardUiState(
    val cards: List<Flashcard> = emptyList(),
    val isLoading: Boolean = false,
    val currentCardIndex: Int = 0,
    val isFlipped: Boolean = false,
    val errorMessage: String? = null
)

class FlashcardViewModel(private val repository: FlashcardRepository) : ViewModel() {

    private val _uiState = MutableStateFlow(FlashcardUiState())
    val uiState: StateFlow<FlashcardUiState> = _uiState.asStateFlow()

    init {
        loadFlashcards()
    }

    private fun loadFlashcards() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true)
            try {
                // Use allCards instead of unmasteredCards
                repository.allCards.collect { cards ->
                    _uiState.value = _uiState.value.copy(
                        cards = cards,
                        isLoading = false
                    )
                }
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(
                    errorMessage = "Failed to load cards: ${e.message}"
                )
            }
        }
    }

    fun addFlashcard(french: String, english: String) {
        viewModelScope.launch {
            val newCard = Flashcard(
                frenchWord = french,
                englishTranslation = english
            )
            repository.insert(newCard)  // Use insert, not insertCard
        }
    }

    fun flipCard() {
        _uiState.value = _uiState.value.copy(
            isFlipped = !_uiState.value.isFlipped
        )
    }

    fun nextCard() {
        _uiState.value = _uiState.value.copy(
            currentCardIndex = (_uiState.value.currentCardIndex + 1) %
                    _uiState.value.cards.size,
            isFlipped = false
        )
    }

    fun previousCard() {
        _uiState.value = _uiState.value.copy(
            currentCardIndex = (_uiState.value.currentCardIndex - 1 +
                    _uiState.value.cards.size) %
                    _uiState.value.cards.size,
            isFlipped = false
        )
    }
}