package com.example.koin_practice.koin

import androidx.room.Room
import com.example.koin_practice.db.MyDB
import com.example.koin_practice.repository.MyRepository
import com.example.koin_practice.viewModels.MyViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModuleInfo = module {

    single {
        Room.databaseBuilder(androidContext(), MyDB::class.java, "books_database").build()
    }
    single {
        get<MyDB>().getDao()
    }
    single {
        MyRepository(get())
    }

}

val myViewModel = module {
    viewModel {
        MyViewModel(get())
    }
}
