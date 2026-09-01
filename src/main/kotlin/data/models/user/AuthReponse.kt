package com.example.data.models.user

import kotlinx.serialization.Serializable

@Serializable
data class AuthReponse(
    val token: String,
    val user: User
)
