package com.example.server_exam.error

import com.example.server_exam.domain.response.BasicResponse
import javassist.NotFoundException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class RestControllerAdvisor {
    @ExceptionHandler(NotFoundException::class)
    fun notFoundExceptionHandle(e: NotFoundException): BasicResponse {
        return BasicResponse(HttpStatus.NOT_FOUND, e.message.toString())
    }
}