package com.example.gramasuvidha

data class Project(
    val id: String,
    val name: String,
    val description: String,
    val category: String,
    val imageUrl: String? = null
)