package com.hyperborge.pablosnake.presentation.game_screen

import android.content.res.Configuration
import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hyperborge.pablosnake.presentation.game_screen.composables.DirectionButtons
import com.hyperborge.pablosnake.presentation.game_screen.composables.SnakeField
import com.hyperborge.pablosnake.presentation.theme.theme.PablosnakeTheme
import kotlin.time.ExperimentalTime

@ExperimentalMaterial3Api
@ExperimentalFoundationApi
@Composable
fun GameScreen(viewModel: GameViewModel) {
    val game = viewModel.game

    Scaffold(topBar = {
        CenterAlignedTopAppBar(
            title = {
                IconButton(
                    modifier = Modifier.size(30.dp),
                    onClick = {
                        Log.d("DEBUGZZ", "refresh clicked")
                        viewModel.onEvent(GameEvent.Reset)
                    }) {
                    Icon(Icons.Default.Refresh, contentDescription = null)
                }
            }
        )
    }) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            SnakeField(cells = game.cells.value)
            DirectionButtons(onEvent = { viewModel.onEvent(GameEvent.DirectionChanged(it)) })
        }
    }
}

@ExperimentalTime
@ExperimentalFoundationApi
@ExperimentalMaterial3Api
@Preview(name = "Light mode", uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true)
@Preview(name = "Dark mode", uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun Preview() {
    PablosnakeTheme {
        GameScreen(viewModel = GameViewModel())
    }
}
