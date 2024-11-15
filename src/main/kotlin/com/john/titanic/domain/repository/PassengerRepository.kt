package com.john.titanic.domain.repository

import com.john.titanic.domain.entities.Passenger
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PassengerRepository: JpaRepository<Passenger, Long> {

    fun findBySurvivedAndPclass(survived: Boolean, pclass: Int, pageable: Pageable): Page<Passenger>

}