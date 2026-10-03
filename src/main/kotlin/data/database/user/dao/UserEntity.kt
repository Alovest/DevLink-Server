package com.example.data.database.user.dao

import com.example.data.database.user.table.UserTable
import org.jetbrains.exposed.dao.UUIDEntity
import org.jetbrains.exposed.dao.UUIDEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import java.util.UUID

class UserEntity(id: EntityID<UUID>) : UUIDEntity(id) {
    companion object : UUIDEntityClass<UserEntity>(UserTable)
    var email by UserTable.email
    var username by UserTable.username
    var password by UserTable.password
}