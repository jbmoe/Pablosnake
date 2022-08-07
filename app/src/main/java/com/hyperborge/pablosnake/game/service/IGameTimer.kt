package com.hyperborge.pablosnake.game.service

interface IGameTimer {
    fun setCallback(callback: (() -> Unit)?)
    fun start()
    fun stop()
    fun reset()
}