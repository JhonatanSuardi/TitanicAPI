package com.john.titanic.service

import com.john.titanic.domain.entities.Passenger
import com.john.titanic.domain.repository.PassengerRepository
import com.john.titanic.domain.repository.PassengerSpecifications
import com.john.titanic.presentation.dto.PagedPassengerDto
import com.john.titanic.presentation.dto.PassengerDto
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class PassengerService(
    private val passengerRepository: PassengerRepository
) {

    fun getSurvivedPassenger(
        survived: Boolean?,
        pClass: Int?,
        pageable: Pageable): PagedPassengerDto {


        return passengerRepository.findAll(PassengerSpecifications.withSurvivedAndPclass(survived, pClass), pageable).toPagedPassengerDto()
    }
}

private fun Page<Passenger>.toPagedPassengerDto(): PagedPassengerDto {
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
