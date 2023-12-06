package com.example.roomdatabase.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.roomdatabase.R
import com.example.roomdatabase.ui.page.EntryDestination
import com.example.roomdatabase.ui.page.HomeDestination
import com.example.roomdatabase.ui.page.HomeScreen
import com.example.roomdatabase.ui.page.StudentsEntryScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StudentsTopAppBar(
    title: String,
    canNavigateBack: Boolean,
    modifier: Modifier = Modifier,
    scrollBehavior: TopAppBarScrollBehavior? = null,
    navigateUp: () -> Unit = {}
) {
    CenterAlignedTopAppBar(title = { Text(title) },
        modifier = modifier,
        scrollBehavior = scrollBehavior,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back)
                    )
                }
            }
        })
}

@Composable
fun NavigationHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = HomeDestination.route,
        modifier = Modifier
    )
    {
        composable(HomeDestination.route) {
            HomeScreen(
                navigateToItemEntry = { navController.navigate(EntryDestination.route) },
            )
        }
        composable(EntryDestination.route) {
            StudentsEntryScreen(navigateBack = { navController.popBackStack() })
        }
    }
}