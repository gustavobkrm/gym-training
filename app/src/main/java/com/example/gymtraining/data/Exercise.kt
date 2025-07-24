package com.example.gymtraining.data

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "exercise",
    foreignKeys = [
        ForeignKey(
            entity = Category::class,
            parentColumns = ["categoriaId"],
            childColumns = ["categoriaId"],
            onDelete = ForeignKey.SET_NULL // ou CASCADE, dependendo da lógica que quiser
        )
    ],
    indices = [Index("categoriaId")] // melhora performance de joins
)

data class Exercise(
    @PrimaryKey(autoGenerate = true)
    val exerciseId: Long = 0,
    val nome: String,
    val categoriaId: Long // chave estrangeira para categoria (você pode criar a entidade Categoria também)
)