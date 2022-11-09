package com.example.instagram.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.instagram.IgViewModel

@Composable
fun SearchScreen(navController: NavController, viewModel: IgViewModel) {
    Column(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.weight(1f)) {
            Text(text = "This is SearchScreen")
        }

        BottomNavigationMenu(BottomNavigationItem.SEARCH, navController = navController)
    }
}