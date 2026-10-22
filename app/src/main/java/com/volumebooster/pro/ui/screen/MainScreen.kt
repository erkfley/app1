package com.volumebooster.pro.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.unit.*
import com.volumebooster.pro.ui.viewmodel.AudioViewModel

@Composable
fun MainScreen(viewModel: AudioViewModel) {
    val boostLevel by viewModel.boostLevel.collectAsState()
    val isBoosting by viewModel.isBoosting.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Volume Booster Pro", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))
        Text("Boost Level: $boostLevel%", style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = { viewModel.toggleBoost() }) {
            Text(if (isBoosting) "Stop Boost" else "Start Boost")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            Button(onClick = { viewModel.decreaseBoost() }) { Text("-") }
            Spacer(modifier = Modifier.width(16.dp))
            Button(onClick = { viewModel.increaseBoost() }) { Text("+") }
        }
    }
}
