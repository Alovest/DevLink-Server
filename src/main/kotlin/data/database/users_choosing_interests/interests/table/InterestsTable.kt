package com.example.data.database.users_choosing_interests.interests.table

import org.jetbrains.exposed.dao.UUIDEntityClass
import org.jetbrains.exposed.dao.id.UUIDTable

object InterestsTable: UUIDTable("interests_table") {
    val name = varchar("name", 64)
}