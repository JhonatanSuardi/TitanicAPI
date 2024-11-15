package com.john.titanic.presentation.dto;

data class PagedPassengerDto(
    val passengerDto: List<PassengerDto>,
    val currentPage: String,
    val totalPages: String,
    val pageSize: String,
    val totalElements: String
)
