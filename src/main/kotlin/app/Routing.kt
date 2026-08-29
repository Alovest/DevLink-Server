package com.example.app

import com.example.application_layer.service_auth.JwtService
import com.example.application_layer.service_user.UserService
import com.example.data.repository.UserActionRepositoryImpl
import com.example.domain.UserActionRepository
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.auth.*

fun Application.configureRouting() {
    val repository: UserActionRepository = UserActionRepositoryImpl()
    val userService = UserService(repository)
    val jwtService = JwtService(environment.config, userService)
    routing {
        route("/user") {
            registerRoute(userService, jwtService)
        }
    }
}