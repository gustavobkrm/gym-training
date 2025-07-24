package com.example.gymtraining.data

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index

@Entity(
    tableName = "training_day_exercise_cross_ref",
    primaryKeys = ["trainingDayId", "exerciseId"],
    foreignKeys = [
        ForeignKey(
            entity = TrainingDay::class,
            parentColumns = ["trainingDayId"],
            childColumns = ["trainingDayId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Exercise::class,
            parentColumns = ["exerciseId"],
            childColumns = ["exerciseId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("trainingDayId"), Index("exerciseId")]
)
data class TrainingDayExerciseCrossRef(
    val trainingDayId: Long,
    val exerciseId: Long
)