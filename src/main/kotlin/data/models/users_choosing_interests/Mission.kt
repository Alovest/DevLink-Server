package com.example.data.models.users_choosing_interests

import com.example.util.UUIDSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.util.UUID

@Serializable
enum class Mission {
    @SerialName("grow my network")
    GROW_MY_NETWORK,

    @SerialName("find co-founder")
    FIND_CO_FOUNDER,

    @SerialName("find a job")
    FIND_A_JOB,

    @SerialName("learn & improve my skills")
    LEARN_AND_IMPROVE_MY_SKILLS,

    @SerialName("build my own project")
    BUILD_MY_OWN_PROJECT,

    @SerialName("join a project")
    JOIN_A_PROJECT,
}
