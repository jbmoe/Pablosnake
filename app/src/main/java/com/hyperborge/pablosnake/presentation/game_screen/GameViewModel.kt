package com.hyperborge.pablosnake.presentation.game_screen

import androidx.lifecycle.ViewModel
import com.hyperborge.pablosnake.game.Game
import com.hyperborge.pablosnake.game.service.GameTimer

class GameViewModel : ViewModel() {
    private val _game: Game = Game(12, 12, GameTimer)
    val game = _game

    fun onEvent(event: GameEvent) {
        when (event) {
            is GameEvent.DirectionChanged -> _game.changeDirection(event.direction)
            GameEvent.Reset -> _game.reset()
        }
    }
}