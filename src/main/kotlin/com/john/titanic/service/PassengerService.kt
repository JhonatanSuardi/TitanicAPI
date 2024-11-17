package com.john.titanic.service

import com.john.titanic.domain.entities.Passenger
import com.john.titanic.domain.repository.PassengerRepository
import com.john.titanic.domain.repository.PassengerSpecifications
import com.john.titanic.infrastructure.mapper.toPagedPassengerDto
import com.john.titanic.presentation.dto.PagedPassengerDto
import com.john.titanic.presentation.dto.PassengerDto
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import kotlin.jvm.optionals.getOrElse

@Service
class PassengerService(
    private val passengerRepository: PassengerRepository
) {

    fun getPassengers(
        survived: Boolean?,
        pClass: Int?,
        pageable: Pageable): PagedPassengerDto {


        return passengerRepository.findAll(PassengerSpecifications.withSurvivedAndPclass(survived, pClass), pageable).toPagedPassengerDto()
    }

    fun getPassengersById(passengerId: Long): PassengerDto {
        val passenger = passengerRepository.findById(passengerId).getOrElse {
            throw NoSuchElementException("It was not possible to find the Passenger with the given id: $passengerId")
        }

        return passenger.toPassengerDto()
    }
}

private fun Passenger.toPassengerDto(): PassengerDto {
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

