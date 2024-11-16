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
            PassengerDto(
                id = it.id,
                survived = it.survived,
                pclass = it.pclass,
                name = it.name,
                sex = it.sex,
                age = it.age,
                sibSp = it.sibSp,
                parch = it.parch,
                ticket = it.ticket,
                fare = it.fare,
                cabin = it.cabin,
                embarked = it.embarked
            )
        },
        totalElements = totalElements.toString(),
        pageSize = size.toString(),
        currentPage = pageable.pageNumber.toString(),
        totalPages = (totalPages - 1).toString()

    )
}
