package com.example.gymtraining.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.gymtraining.data.Category

@Dao
interface CategoryDAO {
    @Insert
    suspend fun insert(category: Category)
    @Query("SELECT * FROM category")
    suspend fun getCategories(): List<Category>
}