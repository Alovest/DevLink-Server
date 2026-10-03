package com.example.data.models.users_choosing_interests

import com.example.util.UUIDSerializer
import kotlinx.serialization.Serializable
import java.util.UUID

@Serializable
data class Experience(
    @Serializable(with = UUIDSerializer::class)
    val id: UUID,
    val name: String,
)
