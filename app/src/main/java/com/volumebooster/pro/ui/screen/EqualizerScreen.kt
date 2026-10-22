package com.volumebooster.pro.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.unit.*
import com.volumebooster.pro.ui.viewmodel.EqualizerViewModel

@Composable
fun EqualizerScreen(viewModel: EqualizerViewModel) {
    val bassBoost by viewModel.bassBoost.collectAsState()
    val trebleBoost by viewModel.trebleBoost.collectAsState()

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Equalizer", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))
        Text("Bass: $bassBoost%")
        Slider(
            value = bassBoost.toFloat(),
            onValueChange = { viewModel.setBassBoost(it.toInt()) },
            valueRange = 0f..100f
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text("Treble: $trebleBoost%")
        Slider(
            value = trebleBoost.toFloat(),
            onValueChange = { viewModel.setTrebleBoost(it.toInt()) },
            valueRange = 0f..100f
        )
    }
}
