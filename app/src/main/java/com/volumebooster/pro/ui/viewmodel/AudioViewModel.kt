package com.volumebooster.pro.ui.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class AudioViewModel : ViewModel() {
    private val _boostLevel = MutableStateFlow(50)
    val boostLevel: StateFlow<Int> = _boostLevel.asStateFlow()

    private val _isBoosting = MutableStateFlow(false)
    val isBoosting: StateFlow<Boolean> = _isBoosting.asStateFlow()

    fun toggleBoost() {
        _isBoosting.value = !_isBoosting.value
    }

    fun setBoostLevel(level: Int) {
        _boostLevel.value = level.coerceIn(0, 100)
    }

    fun increaseBoost() {
        setBoostLevel(_boostLevel.value + 5)
    }

    fun decreaseBoost() {
        setBoostLevel(_boostLevel.value - 5)
    }
}
