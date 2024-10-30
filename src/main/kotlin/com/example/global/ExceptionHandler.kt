package com.example.global

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*

fun Application.configureExceptionHandler() {
    install(StatusPages) {
        exception<Throwable> { call, cause ->
            call.respond(
                HttpStatusCode.InternalServerError, mapOf(
                "code" to "500",
                "message" to (cause.message ?: "An unknown error occurred")
            )
            )
        }
    }
}