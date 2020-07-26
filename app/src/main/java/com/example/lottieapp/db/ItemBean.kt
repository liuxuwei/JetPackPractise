package com.example.lottieapp.db

import androidx.paging.DataSource
import androidx.room.*


@Entity(tableName = "tb_item")
data class ItemBean (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo
    val name: String,   //名字
    @ColumnInfo
    val color: Int
)

@Dao
interface ItemDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(item: List<ItemBean>)

    @Query("select * from tb_item")
    fun queryAll(): DataSource.Factory<Int, ItemBean>
}