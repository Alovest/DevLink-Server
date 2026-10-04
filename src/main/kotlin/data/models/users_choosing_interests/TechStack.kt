package com.example.data.models.users_choosing_interests

import com.example.util.UUIDSerializer
import kotlinx.serialization.Serializable
import java.util.UUID

enum class TechStack {
    //Languages:
    Kotlin,
    Java,
    Python,
    C_plus_plus,
    C_sharp,
    Go,
    Rust,
    Swift,
    C,
    JavaScript,
    TypeScript,
    Dart,
    PHP,

    //Technologies:
    Jetpack_Compose,
    Ktor,
    Android,
    Spring,
    React,
    Flutter,
    Git,
    PostgreSQL,
    dot_NET,
    Unity,
    Docker,
    Node_js,
    Firebase,
    AWS,

    //Interests/Fields:
    Mobile,
    Backend,
    Frontend,
    Full_Stack,
    AI,
    Game_Dev,
    Data_Science,
    Embedded,
}
