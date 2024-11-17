package com.john.titanic.presentation.dto

class BusinessError(
    val message: String?,
    val detail: String?
) {
    constructor(message: String?) : this(message, "")
}