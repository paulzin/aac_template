package com.pavlozin.aactemplate.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface MainDao {
    @Query("SELECT * FROM main")
    fun getMainModel(): LiveData<List<MainModel>>

    @Insert
    suspend fun insertMainModel(mainModel: MainModel): Long

    @Query("DELETE FROM main")
    suspend fun deleteAll()
}
