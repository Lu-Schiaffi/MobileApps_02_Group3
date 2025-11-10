package com.example.myapplication.Repository.API

import com.example.myapplication.Repository.Models.City
import com.example.myapplication.Repository.Models.Clima
import com.example.myapplication.Repository.Models.ListForecast

interface RepoInterface {
    suspend fun fetchWeather(lat: Float, lon: Float): Clima
    suspend fun fetchForecast(name: String): List<ListForecast>
    suspend fun searchCity(city: String): List<City>
}