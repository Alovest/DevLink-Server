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
    private val audience = getConfigProperty("jwt.audience")
    private val issuer = getConfigProperty("jwt.issuer")
    private val secret = getConfigProperty("jwt.secret")
    val realm = getConfigProperty("jwt.realm")

    val jwtVerifier: JWTVerifier =
        JWT.require(Algorithm.HMAC256(secret))
            .withAudience(audience)
            .withIssuer(issuer)
            .build()

    fun createJwtTokenLogin(userRequest: UserRequest): String? {
        val foundUser = userService.findByUsername(userRequest.username)
        return if (foundUser != null && foundUser.password == userRequest.password) {
            createJwtTokenRegister(foundUser)
        } else null
    }

    fun createJwtTokenRegister(user: User): String? {
       return JWT.create()
            .withIssuer(issuer)
            .withAudience(audience)
            .withClaim("username", user.username)
            .withExpiresAt(Date(System.currentTimeMillis() + 3_600_000))
            .sign(Algorithm.HMAC256(secret))
    }

    fun customValidator(credential: JWTCredential): JWTPrincipal? {
        val username = extractUsername(credential)
        val foundUser = username?.let { userService::findByUsername }
        return if (foundUser != null && audienceMatches(credential)) {
            JWTPrincipal(credential.payload)
        } else null
    }

    fun audienceMatches(credential: JWTCredential): Boolean =
        credential.payload.audience.contains(audience)

    fun extractUsername(credential: JWTCredential): String? =
        credential.payload.getClaim("username").asString()

    fun getConfigProperty(path: String): String
    = config.property(path).getString()
}