package com.hyperborge.pablosnake.game.util

object IntExtensions {

    /**
     * Returns a random integer within the range of 0 until this number
     */
    fun Int.randomUntil(): Int {
        return if (this < 0) {
            (this until 0).random()
        } else if (this > 0) {
            (0 until this).random()
        } else {
            0
        }
    }
}