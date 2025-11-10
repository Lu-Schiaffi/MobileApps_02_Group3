package com.example.myapplication.Presentation.Cities

import com.example.myapplication.Repository.Models.City

sealed class CitiesStates {
    data object Empty: CitiesStates()
    data object Loading: CitiesStates()
    data class Result( val cities : List<City> ) : CitiesStates()
    data class Error(val msg: String): CitiesStates()
}