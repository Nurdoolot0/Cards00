package com.example.cards

import java.io.Serializable

data class Continent(
    val name: String,
    val description: String,
    val imageUrl: String,
    val countries: List<Country>

) : Serializable


