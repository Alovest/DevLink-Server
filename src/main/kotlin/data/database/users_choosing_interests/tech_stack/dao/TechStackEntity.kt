package com.example.data.database.users_choosing_interests.tech_stack.dao

import com.example.data.database.users_choosing_interests.teck_stack.table.TechStackTable
import org.jetbrains.exposed.dao.UUIDEntity
import org.jetbrains.exposed.dao.UUIDEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import java.util.UUID

class TechStackEntity(id: EntityID<UUID>) : UUIDEntity(id) {
    companion object : UUIDEntityClass<TechStackEntity>(TechStackTable)
    var name by TechStackTable.name
}