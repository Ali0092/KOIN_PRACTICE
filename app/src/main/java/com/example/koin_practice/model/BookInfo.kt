package com.example.koin_practice.model

import androidx.room.Entity
import androidx.room.PrimaryKey

//Basically the Table for DB that contains the following attributes of data...
@Entity(tableName = "book_table")
data class BookInfo(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val title: String,
    val edition: String,
    val author: String,
    val publication: String
)
