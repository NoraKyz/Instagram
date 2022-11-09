package com.example.instagram.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.instagram.DestinationScreen

enum class BottomNavigationItem(val icon: ImageVector, val destination: DestinationScreen) {
    FEED(Icons.Filled.Home, DestinationScreen.Feed),
    SEARCH(Icons.Filled.Search, DestinationScreen.Search),
    POSTS(Icons.Filled.Person, DestinationScreen.MyPosts)
}

@Composable
fun BottomNavigationMenu(selectedItem: BottomNavigationItem, navController: NavController) {

    BottomNavigation {
        BottomNavigationItem.values().forEach() { item ->
            BottomNavigationItem(
                selected = item == selectedItem,
                onClick = {
                    navigateTo(navController, item.destination)
                },
                icon = {
                    Icon(imageVector = item.icon, contentDescription = null)
                })
        }
    }
}