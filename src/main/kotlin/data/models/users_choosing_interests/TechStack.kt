package com.example.data.models.users_choosing_interests

import com.example.util.UUIDSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.util.UUID

@Serializable
enum class TechStack {
    // LANGUAGES:
    @SerialName("kotlin")
    KOTLIN,

    @SerialName("java")
    JAVA,

    @SerialName("python")
    PYTHON,

    @SerialName("C++")
    C_PLUS_PLUS,

    @SerialName("C#")
    C_SHARP,

    @SerialName("go")
    GO,

    @SerialName("rust")
    RUST,

    @SerialName("swift")
    SWIFT,

    @SerialName("C")
    C,

    @SerialName("javascript")
    JAVASCRIPT,

    @SerialName("typescript")
    TYPESCRIPT,

    @SerialName("dart")
    DART,

    @SerialName("php")
    PHP,

    //

    //  TECHNOLOGIES:

    @SerialName("jetpack compose")
    JETPACK_COMPOSE,

    @SerialName("ktor")
    KTOR,

    @SerialName("android")
    ANDROID,

    @SerialName("spring")
    SPRING,

    @SerialName("react")
    REACT,

    @SerialName("flutter")
    FLUTTER,

    @SerialName("git")
    GIT,

    @SerialName("postgreSQL")
    POSTGRESQL,

    @SerialName(".net")
    DOTE_NET,

    @SerialName("unity")
    UNITY,

    @SerialName("docker")
    DOCKER,

    @SerialName("node.js")
    NODEJS,

    @SerialName("firebase")
    FIREBASE,

    @SerialName("AWS")
    AWS,

    //

    // INTERESTS/FIELDS:

    @SerialName("mobile")
    MOBILE,

    @SerialName("backend")
    BACKEND,

    @SerialName("frontend")
    FRONTEND,

    @SerialName("full stack")
    FULLSTACK,

    @SerialName("AI")
    AI,

    @SerialName("game dev")
    GAMEDEV,

    @SerialName("data science")
    DATA_SCIENCE,

    @SerialName("embedded")
    EMBEDDED,
    //

}
