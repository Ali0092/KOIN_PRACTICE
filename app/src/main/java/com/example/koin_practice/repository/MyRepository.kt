package com.example.koin_practice.repository

import androidx.lifecycle.LiveData
import com.example.koin_practice.db.MyDao
import com.example.koin_practice.model.BookInfo

class MyRepository(private val dao: MyDao) {

    val allBookInfo:LiveData<List<BookInfo>> = dao.getAllData()

    fun setBookInfo(bookInfo: BookInfo){
        dao.setBookInfo(bookInfo)
   }
}