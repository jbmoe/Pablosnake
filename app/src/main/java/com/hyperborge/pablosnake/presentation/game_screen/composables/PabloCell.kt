package com.hyperborge.pablosnake.presentation.game_screen.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import com.hyperborge.pablosnake.game.Cell
import com.hyperborge.pablosnake.game.CellState

@Composable
fun PabloCell(cell: Cell) {
    val color = when (cell.cellState) {
        CellState.BLANK -> Color.White
        CellState.SNAKE -> Color.Black
        CellState.APPLE -> Color.Red
    }

    Box(
        modifier = Modifier
            .size(30.dp)
            .clip(RectangleShape)
            .background(color),
    )
}
