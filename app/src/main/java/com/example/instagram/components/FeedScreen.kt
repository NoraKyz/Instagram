package com.example.instagram.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.example.instagram.IgViewModel

@Composable
fun FeedScreen(
    navController: NavController = NavController(LocalContext.current),
    viewModel: IgViewModel
) {
    Column(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.weight(1f)) {
            Text(text = "This is Feed")
        }

        BottomNavigationMenu(BottomNavigationItem.FEED, navController = navController)
    }

}


