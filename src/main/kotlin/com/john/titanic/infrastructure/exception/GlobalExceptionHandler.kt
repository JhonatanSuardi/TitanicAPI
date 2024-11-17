package com.john.titanic.infrastructure.exception

import com.john.titanic.presentation.dto.BusinessError
import jakarta.validation.ConstraintViolationException
import org.springframework.http.HttpStatus
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

    @ExceptionHandler(NoSuchElementException::class)
    fun handleNosuckElementException(ex: NoSuchElementException): ResponseEntity<BusinessError> {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(BusinessError(ex.message))
    }

    private fun handleValidationInternal(
        ex: ConstraintViolationException
    ): ResponseEntity<Any> {
        return ResponseEntity.badRequest().body( ex.constraintViolations.map { BusinessError(it.propertyPath.
        toString().removePrefix("getPassengers."), it.messageTemplate)})
    }
}