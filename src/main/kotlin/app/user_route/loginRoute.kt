package com.example.app.user_route

import com.example.application_layer.service_auth.JwtService
import com.example.application_layer.service_user.UserService
import com.example.data.models.user.request.UserRequest
import io.ktor.http.HttpStatusCode
import io.ktor.server.request.receive
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.post
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.put

fun Route.loginRoute(
    userService: UserService,
    jwtService: JwtService,
){
    post("/login"){
        val credentials = call.receive<UserRequest>()
        val user = userService.loginUser(credentials.username, credentials.password)
        if (user != null){
            val token = jwtService.createJwtTokenLogin(user)

            call.respond(HttpStatusCode.OK, buildJsonObject{
                put("token", token)
            })
        } else {
            call.respond(HttpStatusCode.Unauthorized, "Неверное имя пользователя или пароль")
        }
    }
}