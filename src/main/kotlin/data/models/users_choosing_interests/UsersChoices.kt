package com.example.data.models.users_choosing_interests

import kotlinx.serialization.Serializable
import kotlin.uuid.Uuid

@Serializable
data class UsersChoices(
    val experience: List<Experience> = emptyList(),
    val mission: List<Mission> = emptyList(),
    val techstack: List<TechStack> = emptyList(),
    val interests: List<Interests> = emptyList(),
)
