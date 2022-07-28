package com.example.koin_practice.screens

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.koin_practice.databinding.BookInfoItemBinding
import com.example.koin_practice.model.BookInfo

class ListFragmentAdapter : RecyclerView.Adapter<ListFragmentAdapter.MyViewHolder>() {

    var bookList = emptyList<BookInfo>()

    class MyViewHolder(val binding: BookInfoItemBinding) : RecyclerView.ViewHolder(binding.root) {
        //MyViewHolder Class....
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            BookInfoItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.apply {
            this.bookTitle.text = bookList[position].title
            this.bookAuthor.text = bookList[position].author
            this.bookEdition.text = bookList[position].edition
            this.bookPublisher.text = bookList[position].publication
        }
    }

    override fun getItemCount(): Int = bookList.size

    @SuppressLint("NotifyDataSetChanged")
    fun setData(list: List<BookInfo>) {
        this.bookList = list
        notifyDataSetChanged()
    }
}