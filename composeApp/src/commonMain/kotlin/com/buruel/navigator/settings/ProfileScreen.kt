package com.buruel.navigator.settings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import com.russhwolf.settings.Settings
import com.russhwolf.settings.set

class ProfileScreen : Screen {
    private val settings: Settings = Settings()

    companion object {
        const val KEY_NAME = "NAME"
        const val KEY_VIP = "VIP"
    }

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current
        var name by remember { mutableStateOf("") }
        var isVip by remember { mutableStateOf(false) }

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.weight(1f))
            OutlinedTextField(value = name, onValueChange = { name = it })
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(checked = isVip, onCheckedChange = { isVip = it })
                Text("Eres VIP?")
            }
            Spacer(Modifier.weight(1f))
            Button(onClick = {
                settings[KEY_NAME] = name
                settings[KEY_VIP] = isVip
                navigator?.push(ProfileResultScreen())
            }, enabled = name.isNotEmpty()) {
                Text("Guardar perfil")
            }
            Spacer(Modifier.weight(0.3f))
        }
    }
}