package com.example.data.models.users_choosing_interests

import com.example.util.UUIDSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.util.UUID
import kotlin.uuid.Uuid

@Serializable
enum class Interests{
    @SerialName("startups")
    STARTUPS,

    @SerialName("open source")
    OPEN_SOURCE,

    @SerialName("mobile apps")
    MOBILE_APPS,

    @SerialName("web development")
    WEB_DEVELOPMENT,

    @SerialName("robotics")
    ROBOTICS,

    @SerialName("game development")
    GAME_DEVELOPMENT,

    @SerialName("cybersecurity")
    CYBERSECURITY,

    @SerialName("AI and Machine Learning")
    AI_AND_MACHINE_LEARNING,

    @SerialName("blockchain")
    BLOCKCHAIN,

    @SerialName("cloud computing")
    CLOUD_COMPUTING,

    @SerialName("developer tools")
    DEVELOPER_TOOLS,

    @SerialName("SaaS")
    SAAS,

    @SerialName("FinTech")
    FINE_TECH,

    @SerialName("education")
    EDUCATION,

    @SerialName("productivity")
    PRODUCTIVITY,

    @SerialName("hardware")
    HARMWARE,
}
