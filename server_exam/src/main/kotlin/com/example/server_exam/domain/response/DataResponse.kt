package com.example.server_exam.domain.response

import org.springframework.http.HttpStatus

class DataResponse<T>(status: HttpStatus, val message: String, data: T) : BasicResponse(status, message)