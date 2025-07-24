package com.example.gymtraining.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.gymtraining.data.TrainingDay

@Dao
interface TrainingDayDAO {
    @Insert
    suspend fun insert(trainingDay: TrainingDay)
    @Query("SELECT * FROM training_day")
    suspend fun getTrainingDays(): List<TrainingDay>
}