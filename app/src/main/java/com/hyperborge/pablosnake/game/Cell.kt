package com.hyperborge.pablosnake.game

data class Cell(
    val row: Int,
    val col: Int,
    val cellState: CellState = CellState.BLANK
)
