package com.example.myapplication.Repository.Models

import kotlinx.serialization.Serializable

@Serializable
data class City (
    val name: String,
    val lat: Float,
    val lon: Float,
    val country: String,
    val state: String = ""
)
