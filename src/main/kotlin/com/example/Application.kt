package com.example

import com.example.module.*
import com.example.module.security.configureSecurity
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.routing.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    configureMonitoring()
    configureSerialization()
    configureSecurity()
    routing { configureRoute() }
}

fun Routing.configureRoute() {
    route("/api/v1"){

    }
}
