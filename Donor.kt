package com.example.mad

import kotlinx.serialization.Serializable

@Serializable
data class Donor(
    val name: String = "",
    val dob: String = "",
    val Age:String = "",
    val BloodType: String = ""
)
