package com.example.domain

import com.example.data.models.user.User
import java.util.UUID

interface UserActionRepository {
    val users: MutableList<User>

    fun addUser(user: User): Boolean

    fun findAll(): List<User>

    fun findByEmail(email: String): User?

    fun findByUsername(username: String): User?

    fun findById(id: UUID): User?
}