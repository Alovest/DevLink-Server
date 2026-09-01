package com.example.application_layer.service_user

import com.example.data.database.user.dao.UserEntity
import com.example.data.database.user.table.UserTable
import com.example.data.mappers.user.toDto
import com.example.data.models.user.User
import com.example.domain.UserActionRepository
import kotlinx.coroutines.Dispatchers
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction
import org.mindrot.jbcrypt.BCrypt
import java.util.UUID

class UserService(
    private val userRepository: UserActionRepository
) {
    fun addUser(user: User): User? {
        val foundUser = userRepository.findByUsername(user.username)

        return if (foundUser == null) {
            userRepository.addUser(user)
            user
        }
        else null
    }
    fun findAll(): List<User> =
        userRepository.findAll()

    fun findByEmail(email: String): User? =
        userRepository.findByEmail(email)

    fun findByUsername(username: String): User? =
        userRepository.findByUsername(username)

    fun findById(id: String): User? =
        userRepository.findById(UUID.fromString(id))

   suspend fun createUser(username: String,email: String, password: String): User = dbQuery{
        UserEntity.new {
            this.username = username
            this.email = email
            this.password = BCrypt.hashpw(password, BCrypt.gensalt())
        }.toDto()
    }

    suspend fun loginUser(username: String, password: String): User? = dbQuery{
        val userEntity = UserEntity.find { UserTable.username eq username }.firstOrNull()

        if (userEntity != null && BCrypt.checkpw(password, userEntity.password)) {
        userEntity.toDto()
        } else {
            null
        }
    }
}

private suspend fun <T> dbQuery(block: suspend () -> T): T =
    newSuspendedTransaction(Dispatchers.IO) { block() }