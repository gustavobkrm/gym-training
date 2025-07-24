package com.example.gymtraining.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.gymtraining.data.TrainingDayExerciseCrossRef

@Dao
interface TrainingDayExerciseCrossRefDAO {
    @Insert
    suspend fun insert(crossRef: TrainingDayExerciseCrossRef)
    @Query("SELECT * FROM training_day_exercise_cross_ref WHERE trainingDayId = :trainingDayId")
    suspend fun getExercisesForDay(trainingDayId: Long): List<TrainingDayExerciseCrossRef>
}