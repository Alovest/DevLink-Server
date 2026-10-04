package com.example.data.models.user

import com.example.data.models.users_choosing_interests.UsersChoices
import com.example.util.UUIDSerializer
import kotlinx.serialization.Serializable
import java.util.UUID
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@Serializable
data class User @OptIn(ExperimentalUuidApi::class) constructor(
    @Serializable(with = UUIDSerializer::class)
    val id: Uuid,
    val email: String,
    val username: String,
    val password: String,
    val usersChoices: UsersChoices
)
