package com.example.data.mappers.user

import com.example.data.database.user.dao.UserEntity
import com.example.data.models.user.User

fun UserEntity.toDto(): User = User(
    id = this.id.value,
    email = this.email,
    username = this.username,
    password = this.password,
)