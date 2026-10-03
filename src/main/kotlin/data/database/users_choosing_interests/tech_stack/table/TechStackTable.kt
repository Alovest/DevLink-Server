package com.example.data.database.users_choosing_interests.teck_stack.table

import org.jetbrains.exposed.dao.id.UUIDTable

object TechStackTable: UUIDTable("tech_stack_table") {
    val name = varchar("name", 64)
}