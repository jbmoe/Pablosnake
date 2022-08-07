package com.hyperborge.pablosnake.presentation.game_screen.composables

import android.content.res.Configuration
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hyperborge.pablosnake.game.Direction
import com.hyperborge.pablosnake.presentation.theme.theme.PablosnakeTheme

@ExperimentalFoundationApi
@Composable
fun DirectionButtons(onEvent: (Direction) -> Unit) {
    LazyVerticalGrid(
        modifier = Modifier
            .size(48.dp * 3)
            .clip(RectangleShape),
        cells = GridCells.Fixed(3)
    ) {
        items(9) { place ->
            val (image, direction) = when (place) {
                1 -> Icons.Default.KeyboardArrowUp to Direction.NORTH
                3 -> Icons.Default.KeyboardArrowLeft to Direction.WEST
                5 -> Icons.Default.KeyboardArrowRight to Direction.EAST
                7 -> Icons.Default.KeyboardArrowDown to Direction.SOUTH
                else -> {
                    null to null
                }
            }
            IconButton(
                modifier = Modifier
                    .size(48.dp)
                    .clip(RectangleShape),
                enabled = image != null || direction != null,
                onClick = { direction?.let(onEvent) }
            ) {
                image?.let {
                    Icon(
                        it,
                        null,
                        tint = contentColorFor(backgroundColor = MaterialTheme.colorScheme.background)
                    )
                }
            }
        }
    }
}


@ExperimentalFoundationApi
@Preview(name = "Light mode", uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true)
@Preview(name = "Dark mode", uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun Preview() {
    PablosnakeTheme {
        DirectionButtons(onEvent = {})
    }
}