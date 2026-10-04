package com.example.data.database.user.table

import com.example.data.models.users_choosing_interests.UsersChoices
import org.jetbrains.exposed.v1.core.dao.id.UuidTable
import kotlin.uuid.ExperimentalUuidApi

@OptIn(ExperimentalUuidApi::class)
object UserTable: UuidTable("users") {
    val email = varchar("email", 64)
    val username = varchar("username", 64)
    val password = varchar("password", 64)
}