package com.example.lottieapp

import android.app.Application
import androidx.databinding.ObservableArrayList
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import androidx.recyclerview.widget.DiffUtil
import com.example.lottieapp.db.ItemBean
import com.example.lottieapp.db.UserDatabase

class MainViewModel(application: Application): AndroidViewModel(application) {

    private val context = application.applicationContext


    private val diffCallBack = object : DiffUtil.ItemCallback<ItemBean>() {
        override fun areItemsTheSame(oldItem: ItemBean, newItem: ItemBean): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ItemBean, newItem: ItemBean): Boolean {
            return oldItem.name == newItem.name
        }

    }
    val myAdapter = MyAdapter(diffCallBack)
    var liveList: LiveData<PagedList<ItemBean>>? =null

    init {
        val itemDao = UserDatabase.getInstance(context)
            .getItemDao()

        liveList = LivePagedListBuilder<Int, ItemBean>(
            itemDao.queryAll(),
            PagedList.Config.Builder()
                .setInitialLoadSizeHint(100)
                .setPageSize(50)
                .setEnablePlaceholders(false)
                .setPrefetchDistance(10)
                .build()
        ).build()
    }





}