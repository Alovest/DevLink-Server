package com.example.data.database.users_choosing_interests.interests.dao

import com.example.data.database.users_choosing_interests.interests.table.InterestsTable
import org.jetbrains.exposed.dao.UUIDEntity
import org.jetbrains.exposed.dao.UUIDEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import java.util.UUID

class InterestsEntity(id: EntityID<UUID>) : UUIDEntity(id) {
    companion object : UUIDEntityClass<InterestsEntity>(InterestsTable)
    var name by InterestsTable.name
}