package com.example.koin_practice.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.koin_practice.model.BookInfo
import com.example.koin_practice.repository.MyRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyViewModel(private val repo: MyRepository) : ViewModel() {
    lateinit var getAllBooks: LiveData<List<BookInfo>>

    fun getAllBooksInfo() {
        getAllBooks = repo.allBookInfo
        Log.d("temp","Data has been got .....")

    }

    fun setBookInfo(book: BookInfo) {
        viewModelScope.launch(Dispatchers.IO) {
            repo.setBookInfo(book)
            Log.d("temp","Data has been set .....")
        }
    }


}