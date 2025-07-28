package com.example.gymtraining.di.module

import android.content.Context
import com.example.gymtraining.database.ExerciseDAO
import com.example.gymtraining.database.GymTrainingDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    fun provideExerciseDao(@ApplicationContext context: Context): ExerciseDAO {
        return GymTrainingDatabase.getDatabase(context).exerciseDao()
    }
}