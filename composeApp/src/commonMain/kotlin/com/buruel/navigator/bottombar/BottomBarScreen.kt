package com.buruel.navigator.bottombar

import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.TabDisposable
import cafe.adriel.voyager.navigator.tab.TabNavigator

class BottomBarScreen : Screen {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {
        TabNavigator(
            HomeTab,
            tabDisposable = { tabNavigator ->
                TabDisposable(
                    tabNavigator,
                    listOf(HomeTab, FavTab, ProfileTab),
                )
            }
        ) { tabNavigator ->
            Scaffold(
                topBar = {
                    TopAppBar(title = {
                        Text(
                            tabNavigator.current.options.title
                        )
                    })
                },
                bottomBar = {
                    NavigationBar {
                        val currentTabNavigator = LocalTabNavigator.current

                        NavigationBarItem(
                            selected = currentTabNavigator.current.key == HomeTab.key,
                            label = { Text(HomeTab.options.title) },
                            icon = {
                                Icon(
                                    modifier = Modifier.height(32.dp),
                                    painter = HomeTab.options.icon!!,
                                    contentDescription = null
                                )
                            },
                            onClick = {
                                currentTabNavigator.current = HomeTab
                            }
                        )

                        NavigationBarItem(
                            selected = currentTabNavigator.current.key == FavTab.key,
                            label = { Text(FavTab.options.title) },
                            icon = {
                                Icon(
                                    modifier = Modifier.height(32.dp),
                                    painter = FavTab.options.icon!!,
                                    contentDescription = null
                                )
                            },
                            onClick = {
                                currentTabNavigator.current = FavTab
                            }
                        )

                        NavigationBarItem(
                            selected = currentTabNavigator.current.key == ProfileTab.key,
                            label = { Text(ProfileTab.options.title) },
                            icon = {
                                Icon(
                                    modifier = Modifier.height(32.dp),
                                    painter = ProfileTab.options.icon!!,
                                    contentDescription = null
                                )
                            },
                            onClick = {
                                currentTabNavigator.current = ProfileTab
                            }
                        )
                    }
                },
                content = {
                    CurrentTab()
                }
            )
        }
    }
}