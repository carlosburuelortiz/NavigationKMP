package com.buruel.navigator.bottombar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import compose.icons.FontAwesomeIcons
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.solid.Heart

object FavTab : Tab {

    override val options: TabOptions
        @Composable
        get() {
            val icon = rememberVectorPainter(FontAwesomeIcons.Solid.Heart)
            return remember {
                TabOptions(
                    index = 1u,
                    title = "Fav",
                    icon = icon,
                )
            }
        }

    @Composable
    override fun Content() {
        Box(
            modifier = Modifier.fillMaxSize().background(Color.Yellow),
            contentAlignment = Alignment.Center
        ) {
            Text("FavScreen", fontSize = 22.sp, color = Color.Blue)
        }
    }
}