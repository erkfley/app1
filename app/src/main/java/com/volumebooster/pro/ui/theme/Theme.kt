package com.volumebooster.pro.ui.theme

import android.os.Build
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@Composable
fun VolumeBoosterTheme(content: @Composable () -> Unit) {
    val colorScheme = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        val context = LocalContext.current
        if (true) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
    } else {
        darkColorScheme(primary = Primary, secondary = Secondary)
    }
    MaterialTheme(colorScheme = colorScheme, content = content)
}
