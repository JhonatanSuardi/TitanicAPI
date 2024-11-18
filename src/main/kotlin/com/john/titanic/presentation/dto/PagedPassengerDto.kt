package com.john.titanic.presentation.dto;

data class PagedPassengerDto(
    val passengersDto: List<PassengerDto>,
    val currentPage: String,
    val totalPages: String,
    val pageSize: String,
    val totalElements: String
)
