package com.example.server_exam.domain.response

import org.springframework.http.HttpStatus

open class BasicResponse(status: HttpStatus, message: String) {
    val status: Int = status.value()
}