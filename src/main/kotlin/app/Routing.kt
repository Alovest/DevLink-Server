package com.example.app

import com.example.app.user_route.getUserByIdRoute
import com.example.app.user_route.loginRoute
import com.example.app.user_route.registerRoute
import com.example.application_layer.service_auth.JwtService
import com.example.application_layer.service_user.UserService
import com.example.data.repository.UserActionRepositoryImpl
import com.example.domain.UserActionRepository
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    val repository: UserActionRepository = UserActionRepositoryImpl()
    val userService = UserService(repository)
    val jwtService = JwtService(environment.config, userService)
    routing {
        route("/user") {
            registerRoute(userService, jwtService)
            getUserByIdRoute(userService)
            loginRoute(userService, jwtService)
        }
    }
}