@file:Suppress("unused", "MemberVisibilityCanBePrivate")

package io.lavamc.bedrokt.api

import java.io.File

open class Plugin(
    val name: String,
    val version: String,
    val description: String,
    val authors: List<String>
) : BasePlugin {
    val logger = Logger(name)
    val dataDir = File(PluginManager.pluginsDir, name)
    val commands = mutableListOf<Command>()

    init {
        if (!dataDir.exists()) dataDir.mkdirs()
    }

    fun unload() = PluginManager.unloadPlugin(this)
}