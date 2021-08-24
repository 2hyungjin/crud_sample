package com.example.server_exam.error.advisor

import com.example.server_exam.domain.response.BasicResponse
import com.example.server_exam.error.IdOverlapException
import com.example.server_exam.error.RegisterException
import javassist.NotFoundException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.client.HttpServerErrorException

@RestControllerAdvice
class RestControllerAdvisor {

    @ExceptionHandler(NotFoundException::class)
    fun notFoundExceptionHandle(e: NotFoundException): BasicResponse {
        return BasicResponse(HttpStatus.NOT_FOUND, e.message.toString())
    }

    @ExceptionHandler(RegisterException::class)
    fun registerExceptionHandle(e: RegisterException): BasicResponse {
        return BasicResponse(HttpStatus.BAD_REQUEST, e.message.toString())
    }

    @ExceptionHandler(IdOverlapException::class)
    fun idOverlapExceptionHandle(e: IdOverlapException): BasicResponse {
        return BasicResponse(HttpStatus.BAD_REQUEST, e.message.toString())
    }

    @ExceptionHandler(HttpServerErrorException::class)
    fun httpServerErrorExceptionHandle(e:HttpServerErrorException):BasicResponse{
        return BasicResponse(HttpStatus.INTERNAL_SERVER_ERROR,"서버 오류")
    }
}