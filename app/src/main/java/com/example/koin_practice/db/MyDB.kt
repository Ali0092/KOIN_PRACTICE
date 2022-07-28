package com.example.koin_practice.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.koin_practice.model.BookInfo

@Database(entities = [BookInfo::class], version = 1)
abstract class MyDB : RoomDatabase() {
    abstract fun getDao(): MyDao
}