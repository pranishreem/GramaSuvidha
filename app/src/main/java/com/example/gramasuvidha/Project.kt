package com.example.gramasuvidha

data class Project(
    val id: Int,
    val name: String,
    val budget: String,
    val completionDate: String,
    val currentProgress: Int,
    val status: String,
    val location: String,
    val description: String
)