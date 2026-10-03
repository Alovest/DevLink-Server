package com.example.data.database.users_choosing_interests.experience.dao

import com.example.data.database.init.DatabaseFactory
import com.example.data.database.users_choosing_interests.experience.table.ExperienceTable
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.UUIDEntity
import org.jetbrains.exposed.dao.UUIDEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import java.util.UUID

class ExperienceEntity(id: EntityID<UUID>) : UUIDEntity(id) {
    companion object : UUIDEntityClass<ExperienceEntity>(ExperienceTable)
    var name by ExperienceTable.name
}