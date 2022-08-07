package com.hyperborge.pablosnake.game

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.hyperborge.pablosnake.game.service.IGameTimer
import com.hyperborge.pablosnake.game.util.IntExtensions.randomUntil
import com.hyperborge.pablosnake.game.util.MutableStateExtensions.setValue

class Game(
    private val rowCount: Int,
    private val colCount: Int,
    private val _timer: IGameTimer
) {
    private val _direction = mutableStateOf(Direction.NORTH)
    private val _state = mutableStateOf(GameState.NOT_STARTED)

    private var _cells = mutableStateOf(List(rowCount) { row ->
        List(colCount) { col ->
            Cell(row = row, col = col)
        }
    })
    val cells: State<List<List<Cell>>> = _cells
    private val _snake: MutableList<Cell> = mutableListOf(_cells.value.random().random())

    init {
        updateCells()
    }

    fun changeDirection(direction: Direction) {}

    fun reset() {
        updateCells()
    }

    private fun updateCells() {
        val apple = getRandomCell(except = _snake.toTypedArray())
        _cells.setValue(cells.value.map { row ->
            row.map { cell ->
                when {
                    apple == cell -> cell.copy(cellState = CellState.APPLE)
                    _snake.contains(cell) -> cell.copy(cellState = CellState.SNAKE)
                    else -> cell
                }
            }
        })
    }

    private fun getRandomCell(vararg except: Cell): Cell {
        var i = rowCount.randomUntil()
        var j = colCount.randomUntil()
        var cell = _cells.value[i][j]

        while (except.contains(cell)) {
            i = rowCount.randomUntil()
            j = colCount.randomUntil()
            cell = _cells.value[i][j]
        }

        return cell
    }
}
