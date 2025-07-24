package com.example.gymtraining.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.gymtraining.data.Category
import com.example.gymtraining.data.Exercise
import com.example.gymtraining.data.TrainingDay
import com.example.gymtraining.data.TrainingDayExerciseCrossRef

@Database(entities = [Category::class, Exercise::class, TrainingDay::class, TrainingDayExerciseCrossRef::class], version = 1)
abstract class GymTrainingDatabase: RoomDatabase() {
    abstract fun categoryDao(): CategoryDAO
    abstract fun exerciseDao(): ExerciseDAO
    abstract fun trainingDayDao(): TrainingDayDAO
    abstract fun trainingDayExerciseCrossRefDao(): TrainingDayExerciseCrossRefDAO

    companion object {
        fun getDatabase(context: Context): GymTrainingDatabase{
            return Room.databaseBuilder(context, GymTrainingDatabase::class.java, "gym_training_database").build()
        }
    }
}