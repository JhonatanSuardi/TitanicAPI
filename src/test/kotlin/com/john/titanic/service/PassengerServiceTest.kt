package com.john.titanic.service

import arrow.core.EmptyValue
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.domain.PageRequest

@SpringBootTest
class PassengerServiceTest {

    @Autowired
    private lateinit var service: PassengerService

    @Test
    fun shouldGetAnApiByIDWithValidId() {
        val passengerDto = service.getPassengersById(3)

        passengerDto.id shouldBe 3
        passengerDto.survived shouldBe true
        passengerDto.pclass shouldBe 3
        passengerDto.name shouldBe "Heikkinen, Miss. Laina"
        passengerDto.sex shouldBe "female"
        passengerDto.age shouldBe 26.0
        passengerDto.sibSp shouldBe 0
        passengerDto.parch shouldBe 0
        passengerDto.ticket shouldBe "STON/O2. 3101282"
        passengerDto.fare shouldBe 7.925
        passengerDto.embarked shouldBe "S"
    }

    @Test
    fun shouldNGetAn400ErrorForApiByIDWithWrongId() {
        shouldThrow<NoSuchElementException> { service.getPassengersById(999) }
    }


    @Test
    fun shouldGetAnApiListForGetApisWithRightParameters(){
        val pagedPassengerDto = service.getPassengers(true, 3, PageRequest.of(0,5))

        pagedPassengerDto.passengersDto shouldNotBe EmptyValue
        pagedPassengerDto.currentPage shouldNotBe null
        pagedPassengerDto.pageSize shouldNotBe null
        pagedPassengerDto.totalPages shouldNotBe null
        pagedPassengerDto.totalElements shouldNotBe null
    }

    @Test
    fun shouldNotGetAnApiListForGetApisWithWrongPclassFilterParameters(){
        val pagedPassengerDto = service.getPassengers(true, 5, PageRequest.of(0,5))

        pagedPassengerDto.passengersDto shouldBe listOf()
        pagedPassengerDto.currentPage shouldBe "0"
        pagedPassengerDto.pageSize shouldBe "5"
        pagedPassengerDto.totalPages shouldBe "-1"
        pagedPassengerDto.totalElements shouldBe "0"
    }

    @Test
    fun shouldGetAnApiListForGetApisWithoutFilterParameters(){
        val pagedPassengerDto = service.getPassengers(null, null, PageRequest.of(0,5))

        pagedPassengerDto.passengersDto shouldNotBe EmptyValue
        pagedPassengerDto.currentPage shouldNotBe null
        pagedPassengerDto.pageSize shouldNotBe null
        pagedPassengerDto.totalPages shouldNotBe null
        pagedPassengerDto.totalElements shouldNotBe null
    }
}