package com.example.data.database.users_choosing_interests.experience.table

import org.jetbrains.exposed.dao.id.UUIDTable

object ExperienceTable: UUIDTable("Experience_table") {
    val name = varchar("name", 64)
}