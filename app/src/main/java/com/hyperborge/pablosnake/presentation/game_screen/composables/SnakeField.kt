package com.hyperborge.pablosnake.presentation.game_screen.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.hyperborge.pablosnake.game.Cell

@Composable
fun SnakeField(modifier: Modifier = Modifier, cells: List<List<Cell>>) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(items = cells) { row ->
            LazyRow {
                items(items = row) { cell ->
                    PabloCell(cell = cell)
                }
            }
        }
    }
}