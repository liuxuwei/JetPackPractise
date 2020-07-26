package com.example.lottieapp

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.lottieapp.databinding.ItemRvMainBinding
import com.example.lottieapp.db.ItemBean

class MyAdapter(diff: DiffUtil.ItemCallback<ItemBean>): PagedListAdapter<ItemBean, MyAdapter.ListViewHolder>(diff) {




    class ListViewHolder(private val binding: ItemRvMainBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(item: ItemBean?) {
            binding.bean = item
            binding.listener = View.OnClickListener {
                Log.d("TAG", "点击了$item")
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemRvMainBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}