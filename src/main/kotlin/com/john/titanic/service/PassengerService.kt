package com.john.titanic.service

import com.john.titanic.domain.repository.PassengerRepository
import com.john.titanic.domain.repository.PassengerSpecifications
import com.john.titanic.infrastructure.mapper.toPagedPassengerDto
import com.john.titanic.presentation.dto.PagedPassengerDto
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class PassengerService(
     val passengerRepository: PassengerRepository
) {

    fun getSurvivedPassenger(
        survived: Boolean?,
        pClass: Int?,
        pageable: Pageable): PagedPassengerDto {


        return passengerRepository.findAll(PassengerSpecifications.withSurvivedAndPclass(survived, pClass), pageable).toPagedPassengerDto()
    }
}

