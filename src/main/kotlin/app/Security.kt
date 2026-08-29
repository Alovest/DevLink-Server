package com.example.app

import io.ktor.server.application.*
import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.example.application_layer.service_auth.JwtService
import io.ktor.server.auth.*
import io.ktor.server.auth.jwt.*
import io.ktor.server.auth.ldap.*
import io.ktor.util.*

fun Application.configureSecurity(
    jwtService: JwtService,
) {
    authentication {
        jwt {
         realm = jwtService.realm
            verifier(jwtService.jwtVerifier)
              validate { credential ->
             jwtService.customValidator(credential)
         }
        }
}
}