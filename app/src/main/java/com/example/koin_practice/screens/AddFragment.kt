package com.example.koin_practice.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import com.example.koin_practice.databinding.FragmentAddBinding
import com.example.koin_practice.model.BookInfo
import com.example.koin_practice.viewModels.MyViewModel
import org.koin.androidx.viewmodel.ext.android.getViewModel
import kotlin.random.Random


class AddFragment : Fragment() {
    private lateinit var binding: FragmentAddBinding
    private lateinit var myViewModel:MyViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddBinding.inflate(layoutInflater)
        myViewModel=getViewModel<MyViewModel>()

        binding.addToDB.setOnClickListener {

            val id = Random.nextLong(25)
            val title = binding.title.text.toString()
            val edition = binding.Edition.text.toString()
            val author = binding.author.text.toString()
            val publisher = binding.publisher.text.toString()

            val bookObj = BookInfo(id, title, edition, author, publisher)
            myViewModel.setBookInfo(bookObj)
        }

        return binding.root
    }

}