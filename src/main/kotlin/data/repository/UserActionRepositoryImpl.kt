package com.example.data.repository

import com.example.data.models.user.User
import com.example.domain.UserActionRepository
import java.util.UUID

class UserActionRepositoryImpl(): UserActionRepository {

    override val users: MutableList<User> = mutableListOf()

    override fun addUser(user: User): Boolean {
        return users.add(user)
    }

    override fun findAll(): List<User> {
        return users.toList()
    }

    override fun findByEmail(email: String): User? {
        return users.find { it.email == email }
    }

    override fun findByUsername(username: String): User? {
        return users.find { it.username == username }
    }

    override fun findById(id: UUID): User? {
        return users.find { it.id == id }
    }
}