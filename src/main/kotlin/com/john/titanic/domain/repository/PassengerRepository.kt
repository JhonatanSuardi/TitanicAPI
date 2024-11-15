package com.john.titanic.domain.repository

import com.john.titanic.domain.entities.Passenger
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository

@Repository
interface PassengerRepository: JpaRepository<Passenger, Long>, JpaSpecificationExecutor<Passenger> {


}