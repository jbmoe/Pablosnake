package com.hyperborge.pablosnake.game.util

import androidx.compose.runtime.MutableState

object MutableStateExtensions {
    fun <T> MutableState<T>.setValue(value: T) {
        this.value = value
    }
}