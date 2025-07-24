package com.example.gymtraining.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "category")
data class Category(
    @PrimaryKey(autoGenerate = true)
    val categoriaId: Long = 0,
    val nome: String
)