package com.volumebooster.pro.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.unit.*
import com.volumebooster.pro.ui.viewmodel.SettingsViewModel

@Composable
fun SettingsScreen(viewModel: SettingsViewModel) {
    val autoStart by viewModel.autoStart.collectAsState()
    val headsetOnly by viewModel.headsetOnly.collectAsState()
    val maxBoost by viewModel.maxBoostLevel.collectAsState()

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Settings", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("Auto Start on Boot")
            Spacer(modifier = Modifier.weight(1f))
            Switch(checked = autoStart, onCheckedChange = { viewModel.toggleAutoStart() })
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("Headset Only")
            Spacer(modifier = Modifier.weight(1f))
            Switch(checked = headsetOnly, onCheckedChange = { viewModel.toggleHeadsetOnly() })
        }

        Text("Max Boost Level: $maxBoost%")
        Slider(
            value = maxBoost.toFloat(),
            onValueChange = { viewModel.setMaxBoostLevel(it.toInt()) },
            valueRange = 0f..200f
        )
    }
}
