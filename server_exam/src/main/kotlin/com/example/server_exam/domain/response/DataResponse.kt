package com.example.server_exam.domain.response

import org.springframework.http.HttpStatus

class DataResponse<T>(status: HttpStatus, message: String, val data: T) : BasicResponse(status, message)