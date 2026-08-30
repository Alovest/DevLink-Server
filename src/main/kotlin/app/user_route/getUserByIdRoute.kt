package com.example.app.user_route

import com.example.application_layer.service_user.UserService
import io.ktor.http.HttpStatusCode
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.get

fun Route.getUserByIdRoute(
     userService: UserService,
){
    get("/{id}") {
        val idParam = call.parameters["id"]

        if (idParam == null){
            call.respond(HttpStatusCode.BadRequest, "Неверное айди")
            return@get
        }

        try {
            val user = userService.findById(idParam)

            if (user != null) {
                call.respond(HttpStatusCode.OK, user)
            } else {
                call.respond(HttpStatusCode.NotFound, "Пользователь не найден")
            }
        } catch (e: IllegalArgumentException) {
            call.respond(HttpStatusCode.BadRequest, "Неверный UUID формат")
        }
    }
}