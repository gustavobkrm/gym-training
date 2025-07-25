package com.example.gymtraining.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.gymtraining.data.Exercise

@Dao
interface ExerciseDAO {
    @Insert
    suspend fun insert(exercise: Exercise)
    @Query("SELECT * FROM exercise")
    suspend fun getExercises(): List<Exercise>
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(exercises: List<Exercise>)
}