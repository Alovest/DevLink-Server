package com.example.data.models.user

import com.example.data.models.users_choosing_interests.UsersChoices
import com.example.util.UUIDSerializer
import kotlinx.serialization.Serializable
import java.util.UUID

@Serializable
data class User(
    @Serializable(with = UUIDSerializer::class)
    val id: UUID,
    val email: String,
    val username: String,
    val password: String,
    val usersChoices: UsersChoices
)
