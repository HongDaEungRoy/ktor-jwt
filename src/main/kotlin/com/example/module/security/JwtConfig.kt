package com.example.module.security

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.util.*

class JwtConfig(private val secret: String) {

    fun createToken(username: String): String {
        return JWT.create()
            .withAudience("username")
            .withExpiresAt(
                LocalDateTime.now()
                    .plusHours(1)
                    .toInstant(ZoneOffset.UTC).let { Date.from(it) })

            .withClaim("username", username)
            .sign(Algorithm.HMAC256(secret))
    }
}