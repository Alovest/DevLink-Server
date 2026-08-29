package com.example.data.database.user.table

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.dao.id.UUIDTable

object UserTable: UUIDTable("users") {
    val email = varchar("email", 64)
    val username = varchar("username", 64)
    val password = varchar("password", 64)
}