package com.example.myapplication.Presentation.Cities

import com.example.myapplication.Repository.Models.City

sealed class CitiesStages {
    data object Empty: CitiesStages()
    data object Loading: CitiesStages()
    data class Result( val cities : List<City> ) : CitiesStages()
    data class Error(val msg: String): CitiesStages()
}