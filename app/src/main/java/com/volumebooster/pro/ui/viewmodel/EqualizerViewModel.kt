package com.volumebooster.pro.ui.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class EqualizerViewModel : ViewModel() {
    private val _bassBoost = MutableStateFlow(50)
    val bassBoost: StateFlow<Int> = _bassBoost.asStateFlow()

    private val _trebleBoost = MutableStateFlow(50)
    val trebleBoost: StateFlow<Int> = _trebleBoost.asStateFlow()

    private val _equalizerEnabled = MutableStateFlow(false)
    val equalizerEnabled: StateFlow<Boolean> = _equalizerEnabled.asStateFlow()

    fun setBassBoost(level: Int) {
        _bassBoost.value = level.coerceIn(0, 100)
    }

    fun setTrebleBoost(level: Int) {
        _trebleBoost.value = level.coerceIn(0, 100)
    }

    fun toggleEqualizer() {
        _equalizerEnabled.value = !_equalizerEnabled.value
    }
}
