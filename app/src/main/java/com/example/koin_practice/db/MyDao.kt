package com.example.koin_practice.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.koin_practice.model.BookInfo

@Dao
interface MyDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun setBookInfo(bookInfo: BookInfo)

    @Query("SELECT* FROM BOOK_TABLE")
    fun getAllData(): LiveData<List<BookInfo>>
}