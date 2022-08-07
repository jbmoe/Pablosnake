package com.hyperborge.pablosnake.game.service

import android.util.Log
import java.util.*
import kotlin.concurrent.timer

object GameTimer : IGameTimer {
    private var _timer: Timer? = null
    private var _callback: (() -> Unit)? = null

    override fun setCallback(callback: (() -> Unit)?) {
        Log.d("DEBUGZZ", "callback set")
        _callback = callback
    }

    override fun start() {
        Log.d("DEBUGZZ", "timer start")
        if (_timer == null) {
            _timer = timer(period = 1000, initialDelay = 1000) {
                _callback?.invoke()
            }
        }
    }

    override fun stop() {
        Log.d("DEBUGZZ", "timer stop")
        _timer?.cancel()
        _timer = null
    }

    override fun reset() {
        Log.d("DEBUGZZ", "timer reset")
        stop()
        _callback = null
    }
}
