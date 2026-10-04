package com.example.data.models.user.request

import com.example.data.models.users_choosing_interests.UsersChoices
import kotlinx.serialization.Serializable

@Serializable
data class UserRequest(
    val username: String = "",
    val email: String = "",
    val password: String = "",
    val usersChoices: UsersChoices? = null
)
