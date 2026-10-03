package com.example.data.database.users_choosing_interests.mission.dao

import com.example.data.database.users_choosing_interests.mission.table.MissionTable
import org.jetbrains.exposed.dao.UUIDEntity
import org.jetbrains.exposed.dao.UUIDEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import java.util.UUID

class MissionEntity(id: EntityID<UUID>) : UUIDEntity(id) {
    companion object : UUIDEntityClass<MissionEntity>(MissionTable)
    var name by MissionTable.name
}