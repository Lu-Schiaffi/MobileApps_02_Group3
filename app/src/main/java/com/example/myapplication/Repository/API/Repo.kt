package com.example.myapplication.Repository.API


import com.example.myapplication.Repository.Models.City
import com.example.myapplication.Repository.Models.Clima
import com.example.myapplication.Repository.Models.ForecastDTO
import com.example.myapplication.Repository.Models.ListForecast
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.http.HttpStatusCode
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class Repo : RepoInterface {
    private val apiKey = "af18d49181e03cd53f71b5d26760b36d"

    private val client = HttpClient() {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
            })
        }
    }



    override suspend fun searchCity(city: String): List<City> {
        val response = client.get("https://api.openweathermap.org/geo/1.0/direct") {
            parameter("q", city)
            parameter("limit", 100)
            parameter("appid", apiKey)
        }

        if (response.status == HttpStatusCode.OK) {
            val cities = response.body<List<City>>()
            return cities
        } else {
            throw Exception()
        }
    }

    override suspend fun fetchWeather(lat: Float, lon: Float): Clima {
        val response = client.get("https://api.openweathermap.org/data/2.5/weather") {
            parameter("lat", lat)
            parameter("lon", lon)
            parameter("units", "metric")
            parameter("appid", apiKey)
        }
        if (response.status == HttpStatusCode.OK) {
            val clima = response.body<Clima>()
            return clima
        } else {
            throw Exception()
        }
    }

    override suspend fun fetchForecast(name: String): List<ListForecast> {

        val response = client.get("https://api.openweathermap.org/data/2.5/forecast") {
            parameter("q", name)
            parameter("units", "metric")
            parameter("appid", apiKey)
        }
        if (response.status == HttpStatusCode.OK) {
            val forecast = response.body<ForecastDTO>()
            return forecast.list
        } else {
            throw Exception()
        }

    }
}