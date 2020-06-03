@file:Suppress("unused")

package wtf.lpc.bedrokt.api

import com.andreapivetta.kolor.Color
import com.andreapivetta.kolor.Kolor
import wtf.lpc.bedrokt.logHistory
import kotlin.system.exitProcess

class Logger(private val name: String) {
    private fun log(color: Color, message: String) {
        val fullMessage = Kolor.foreground("-> ", color) + name + Kolor.foreground(" | ", color) + message
        println(fullMessage)
        logHistory.add(fullMessage)
    }

    fun newline() {
        println()
        logHistory.add("\n")
    }

    fun info(message: String) = log(Color.CYAN, message)
    fun warn(message: String) = log(Color.YELLOW, message)
    fun error(message: String) = log(Color.RED, message)
    fun debug(message: String) = log(Color.DARK_GRAY, message)

    fun fatal(message: String) {
        log(Color.RED, message)
        exitProcess(1)
    }
}