package com.john.titanic.infrastructure.mapper

import com.john.titanic.domain.entities.Passenger
import com.john.titanic.presentation.dto.PagedPassengerDto
import com.john.titanic.presentation.dto.PassengerDto
import org.springframework.data.domain.Page

class Mapper {
}

fun Page<Passenger>.toPagedPassengerDto(): PagedPassengerDto {
    return PagedPassengerDto(
        passengerDto = this.content.map {
            it.toPassengerDto()
        },
        totalElements = totalElements.toString(),
        pageSize = size.toString(),
        currentPage = pageable.pageNumber.toString(),
        totalPages = (totalPages - 1).toString()
    )
}

fun Passenger.toPassengerDto(): PassengerDto {
    return PassengerDto(
        id = this.id,
        survived = this.survived,
        pclass = this.pclass,
        name = this.name,
        sex = this.sex,
        age = this.age,
        sibSp = this.sibSp,
        parch = this.parch,
        ticket = this.ticket,
        fare = this.fare,
        cabin = this.cabin,
        embarked = this.embarked
    )
}