package wtf.lpc.bedrokt

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.nukkitx.protocol.bedrock.BedrockPacketCodec
import com.nukkitx.protocol.bedrock.v390.Bedrock_v390
import java.io.File
import java.util.*
import kotlin.concurrent.schedule

val packetCodec: BedrockPacketCodec = Bedrock_v390.V390_CODEC
val jsonMapper: ObjectMapper = ObjectMapper().disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)

fun main() {
    proxyLogger.info(
        "Bedrokt v1.0 - Minecraft ${packetCodec.minecraftVersion} (protocol v${packetCodec.protocolVersion}"
    )

    if (File("/").canWrite()) {
        proxyLogger.warn("Bedrokt has root write access. This IS dangerous because plugins can run any arbitrary code!")
        proxyLogger.warn("It is highly recommended that you stop Bedrokt and ensure it doesn't have access to root.")
        proxyLogger.warn("However, if you know what you're doing and want to start Bedrokt anyway, press enter/return.")

        readLine()
    }

    reloadConfig()
    reloadPlugins()

    startServer()
    Timer().schedule(0, 1) {}
}