package com.example.module.security

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.auth.jwt.*

fun Application.configureSecurity() {
    val jwtSecret = "secret"

    authentication {
        jwt {
            verifier(
                JWT
                    .require(Algorithm.HMAC256(jwtSecret))
                    .acceptExpiresAt(3600) // 1시간의 만료 시간 허용 오차
                    .build()
            )
            validate { credential ->
                if (credential.payload.audience.contains("username")) {
                  JWTPrincipal(credential.payload)
                }  else null
            }
        }
    }
}
