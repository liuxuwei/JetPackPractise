package com.example.lottieapp.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.lottieapp.User


@Entity(tableName = "tb_user")
data class UserBean(
    @PrimaryKey
    val uid: Int = 0,
    @ColumnInfo
    val name: String,
    @ColumnInfo
    val sex: Int, //0 女 1 男
    @ColumnInfo
    val age: Int,
    @ColumnInfo
    val city: String
)


@Dao
interface UserDao{

    @Query("select * from tb_user where uid = 0")
    fun query(): LiveData<UserBean>


    @Insert(entity = UserBean::class, onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: UserBean)

    @Update
    fun update(user: UserBean)

    @Delete
    fun delete(user: UserBean)
}

@Entity(tableName = "tb_status")
data class LoginStatus(
    @PrimaryKey(autoGenerate = false)
    val id: Int = 0,
    @ColumnInfo
    val logged: Boolean
)

@Dao
interface LoginStatusDao {

    @Query("select logged from tb_status where id = 0")
    fun queryStatus(): LiveData<Boolean?>


    @Insert
    fun insertStatus(status: LoginStatus)
}

