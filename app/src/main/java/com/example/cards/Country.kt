package com.example.cards

import java.io.Serializable

data class Country(
    val name: String,
    val description: String,
    val imageUrl: String
) : Serializable

