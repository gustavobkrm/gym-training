package com.example.gymtraining.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "training_day")
data class TrainingDay(
    @PrimaryKey(autoGenerate = true)
    val trainingDayId: Long = 0,
    val dayOfWeek: String // exemplo: "segunda", "terça", etc.
)