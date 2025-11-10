package com.example.myapplication.Presentation.Cities

import com.example.myapplication.Repository.Models.City

sealed class CitiesIntentions {
    data class Search( val cityName:String ) : CitiesIntentions()
    data class Select(val city: City) : CitiesIntentions()
}