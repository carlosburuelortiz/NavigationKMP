package com.buruel.navigator.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import com.buruel.navigator.common.extensions.select
import com.buruel.navigator.settings.ProfileScreen.Companion.KEY_NAME
import com.buruel.navigator.settings.ProfileScreen.Companion.KEY_VIP
import com.russhwolf.settings.Settings

class ProfileResultScreen: Screen {
    private val settings: Settings = Settings()

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current
        val isVip = settings.getBoolean(KEY_VIP, false)
        val backgroundColor = isVip.select(Color.Yellow, Color.White)

        Column(
            modifier = Modifier.fillMaxSize().background(backgroundColor),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            var name = settings.getStringOrNull(KEY_NAME).orEmpty()

            Text("Bienvenid@ $name", fontSize = 26.sp, fontWeight = FontWeight.Bold)
            Button(onClick = {
                settings.clear()
                navigator?.pop()
            }) {
                Text("Volver y borrar datos")
            }
        }
    }
}