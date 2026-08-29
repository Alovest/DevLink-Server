package com.example.app

import com.example.application_layer.service_auth.JwtService
import com.example.application_layer.service_user.UserService
import com.example.data.database.init.DatabaseFactory
import com.example.data.repository.UserActionRepositoryImpl
import com.example.domain.UserActionRepository
import io.ktor.server.application.Application
import io.ktor.server.netty.EngineMain
import io.ktor.server.routing.application
import io.ktor.server.routing.routing

fun main(args: Array<String>) {
    EngineMain.main(args)
}

fun Application.main() {

        DatabaseFactory.init()
        configureSerialization()

        val userRepository: UserActionRepository = UserActionRepositoryImpl()
        val userService = UserService(userRepository)
        val jwtService = JwtService(this.environment.config, userService)

        configureRouting()
        configureSecurity(jwtService)
}