package com.example.gymtraining.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.gymtraining.data.Category

@Dao
interface CategoryDAO {
    @Insert
    suspend fun insert(category: Category)
    @Query("SELECT * FROM category")
    suspend fun getCategories(): List<Category>
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(categories: List<Category>): List<Long>
    @Query("DELETE FROM category")
    suspend fun deleteAll()
}