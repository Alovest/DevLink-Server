package com.example.data.database.users_choosing_interests.mission.table

import org.jetbrains.exposed.dao.id.UUIDTable

object MissionTable: UUIDTable("Mission_table") {
    val name = varchar("name", 64)
}