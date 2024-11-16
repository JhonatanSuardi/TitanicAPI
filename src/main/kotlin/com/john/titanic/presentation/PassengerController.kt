package com.john.titanic.presentation

import com.john.titanic.service.PassengerService
import jakarta.validation.Valid
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import org.springframework.data.domain.PageRequest
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/passengers")
@Validated
class PassengerController(
    private val passengerService: PassengerService
) {

    @GetMapping
    fun getPassengersBy(
        @RequestParam
        survived: Boolean?,
        @RequestParam
        @Valid
        @Max(value = 3, message = "The maximum value for survived must be at most 3.")
        @Min(value = 1, message = "The minimum value for survived must be at most 1.")
        pclass: Int?,
        @RequestParam (defaultValue = "0") page: Int,
        @RequestParam (defaultValue = "5") size: Int
    ): ResponseEntity<Any> {

        val pageable = PageRequest.of(page, size)

        passengerService.getSurvivedPassenger(survived, pclass, pageable).takeIf { it.passengerDto.isNotEmpty() }
            ?.run { return ResponseEntity.ok(this) } ?: return ResponseEntity.noContent().build()

    }


}