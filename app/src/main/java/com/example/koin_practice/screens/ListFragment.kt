package com.example.koin_practice.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.koin_practice.R
import com.example.koin_practice.databinding.FragmentListBinding
import com.example.koin_practice.viewModels.MyViewModel
import org.koin.androidx.viewmodel.ext.android.getViewModel

class ListFragment : Fragment() {

    private lateinit var binding:FragmentListBinding
    private lateinit var myViewModel:MyViewModel
    private val myAdapter by lazy{ ListFragmentAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentListBinding.inflate(layoutInflater)
        myViewModel=getViewModel<MyViewModel>()

        settingUpRecyclerView()

        myViewModel.getAllBooksInfo()
        myViewModel.getAllBooks.observe(viewLifecycleOwner) {
            myAdapter.setData(it)
        }

        binding.addBtn.setOnClickListener {
            this.findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }

        return binding.root
    }

    fun settingUpRecyclerView(){
        binding.recView.adapter=myAdapter
        binding.recView.layoutManager=LinearLayoutManager(requireContext())
    }
}