package com.john.titanic.presentation.dto

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
class PassengerDto(
    val id: Long = 0,
    val survived: Boolean,
    val pclass: Int,
    val name: String,
    val sex: String,
    val age: Double?,
    val sibSp: Int,
    val parch: Int,
    val ticket: String,
    val fare: Double,
    val cabin: String?,
    val embarked: String?
)