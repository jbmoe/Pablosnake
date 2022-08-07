package com.hyperborge.pablosnake.game.util

object ListExtension {
    fun <T> MutableList<T>.addFirst(element: T) {
        this.add(0, element)
    }
}