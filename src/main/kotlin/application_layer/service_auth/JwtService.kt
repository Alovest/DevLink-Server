package com.example.application_layer.service_auth

import com.auth0.jwt.JWT
import com.auth0.jwt.JWTVerifier
import com.auth0.jwt.algorithms.Algorithm
import com.example.application_layer.service_user.UserService
import com.example.data.models.user.User
import com.example.data.models.user.request.UserRequest
import io.ktor.server.auth.Principal
import io.ktor.server.auth.jwt.JWTCredential
import io.ktor.server.auth.jwt.JWTPrincipal
import io.ktor.server.config.ApplicationConfig
import java.util.Date

class JwtService(
    private val config: ApplicationConfig,
    private val userService: UserService
) {
    private val audience = config.propertyOrNull("jwt.audience")?.getString() ?: "default-audience"
    private val issuer = config.propertyOrNull("jwt.issuer")?.getString() ?: "default-issuer"
    private val secret = config.propertyOrNull("jwt.secret")?.getString() ?: "super-secret-key-at-least-32-characters-long"
    val realm = config.propertyOrNull("jwt.realm")?.getString() ?: "default-realm"

    val jwtVerifier: JWTVerifier =
        JWT.require(Algorithm.HMAC256(secret))
            .withAudience(audience)
            .withIssuer(issuer)
            .build()

    fun createJwtTokenLogin(user: User): String {
        return createJwtTokenRegister(user)
    }

    fun createJwtTokenRegister(user: User): String {
        return JWT.create()
            .withIssuer(issuer)
            .withAudience(audience)
            .withClaim("username", user.username)
            .withExpiresAt(Date(System.currentTimeMillis() + 3_600_000))
            .sign(Algorithm.HMAC256(secret))
    }

    suspend fun customValidator(credential: JWTCredential): JWTPrincipal? {
        val username = extractUsername(credential)
        // Оборачиваем вызов в безопасную проверку
        val foundUser = username?.let { userService.findByUsername(it) }

        return if (foundUser != null && audienceMatches(credential)) {
            JWTPrincipal(credential.payload)
        } else null
    }

    fun audienceMatches(credential: JWTCredential): Boolean =
        credential.payload.audience.contains(audience)

    fun extractUsername(credential: JWTCredential): String? =
        credential.payload.getClaim("username").asString()
}