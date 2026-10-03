package com.example.data.models.users_choosing_interests

import com.example.util.UUIDSerializer
import kotlinx.serialization.Serializable
import java.util.UUID
import kotlin.uuid.Uuid

@Serializable
data class Interests(
    @Serializable(with = UUIDSerializer::class)
    val id: UUID,
    val name: String,
)
