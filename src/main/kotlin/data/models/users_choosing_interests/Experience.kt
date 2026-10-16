package com.example.data.models.users_choosing_interests

import com.example.util.UUIDSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.util.UUID

@Serializable
enum class  Experience{
    @SerialName("beginner")
    BEGINNER,

    @SerialName("junior")
    JUNIOR,

    @SerialName("middle")
    MIDDLE,

    @SerialName("senior")
    SENIOR,

    @SerialName("lead")
    LEAD,

    @SerialName("student")
    STUDENT,

    @SerialName("no professional experience yet")
    NO_PROFESSIONAL_EXPERIENCE_YET,
}
