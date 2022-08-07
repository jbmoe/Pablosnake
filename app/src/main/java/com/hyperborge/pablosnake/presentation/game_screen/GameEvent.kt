package com.hyperborge.pablosnake.presentation.game_screen

import com.hyperborge.pablosnake.game.Direction

sealed interface GameEvent {
    object Reset : GameEvent
    data class DirectionChanged(val direction: Direction) : GameEvent
}