package com.example.app

import com.example.application_layer.service_auth.JwtService
import com.example.application_layer.service_user.UserService
import com.example.data.database.user.dao.UserEntity
import com.example.data.database.user.table.UserTable.email
import com.example.data.models.user.request.UserRequest
import io.ktor.http.HttpStatusCode
import io.ktor.server.request.receive
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.post
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction

fun Route.registerRoute(
    userService: UserService,
    jwtService: JwtService,
) {
    post("/register") {
        try {
            val registerRequest = call.receive<UserRequest>()

            if (registerRequest.username.isBlank() || registerRequest.password.isBlank()) {
                call.respond(HttpStatusCode.BadRequest, "Имя и пароль пользователя не могут быть пустыми")
                return@post
            }

            val (newUser, isConflict) = newSuspendedTransaction {
                val existingUser = userService.findByUsername(registerRequest.username)
                if (existingUser != null) {
                    return@newSuspendedTransaction null to true
                }

                val user = userService.createUser(
                    username = registerRequest.username,
                    email = registerRequest.email,
                    password = registerRequest.password,
                )
                user to false
            }

            if (isConflict) {
                call.respond(HttpStatusCode.Conflict, "Пользователь с таким именем уже существует")
                return@post
            }

            if (newUser == null) {
                call.respond(HttpStatusCode.InternalServerError, "Не удалось создать пользователя")
                return@post
            }

            val token = jwtService.createJwtTokenRegister(newUser)

            call.respond(HttpStatusCode.Created, mapOf(
                "token" to token,
                "user" to newUser
            ))
        } catch (e: Exception) {
            call.respond(HttpStatusCode.InternalServerError, "Регистрация упала: ${e.localizedMessage}")
        }
    }
}