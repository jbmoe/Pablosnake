package com.hyperborge.pablosnake.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material3.ExperimentalMaterial3Api
import com.hyperborge.pablosnake.presentation.game_screen.GameScreen
import com.hyperborge.pablosnake.presentation.game_screen.GameViewModel
import com.hyperborge.pablosnake.presentation.theme.theme.PablosnakeTheme

@ExperimentalMaterial3Api
@ExperimentalFoundationApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PablosnakeTheme {
                GameScreen(viewModel = GameViewModel())
            }
        }
    }
}