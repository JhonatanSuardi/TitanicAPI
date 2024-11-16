package com.john.titanic.infrastructure.exception

import com.john.titanic.presentation.dto.InvalidArgumentDto
import jakarta.validation.ConstraintViolationException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class GlobalExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(ConstraintViolationException::class)
    fun handleValidation(ex: ConstraintViolationException): ResponseEntity<Any> {
        return handleValidationInternal(ex)
    }

    private fun handleValidationInternal(
        ex: ConstraintViolationException
    ): ResponseEntity<Any> {
        return ResponseEntity.badRequest().body( ex.constraintViolations.map { InvalidArgumentDto(it.propertyPath.
        toString().removePrefix("getPassengersBy."), it.messageTemplate)})
    }
}