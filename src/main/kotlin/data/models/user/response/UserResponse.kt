package com.example.data.models.user.response

import com.example.util.UUIDSerializer
import kotlinx.serialization.Serializable
import java.util.UUID
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@Serializable
data class UserResponse @OptIn(ExperimentalUuidApi::class) constructor(
    @Serializable(with = UUIDSerializer::class)
    val id: Uuid,
    val email: String,
    val username: String,
)
