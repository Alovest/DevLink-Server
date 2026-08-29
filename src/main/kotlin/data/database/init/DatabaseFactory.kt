package com.example.data.database.init

import com.example.data.database.user.table.UserTable
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

object DatabaseFactory {
    fun init(){
        val driverClassName = "org.sqlite.JDBC"
        val jbcUrl = "jdbc:sqlite:./data.db"
        //val user = "postgres"
       // val password = "secret"

        Database.connect(
            url = jbcUrl,
            driver = driverClassName,

        )

        transaction {
            SchemaUtils.create(UserTable)
        }
    }
}