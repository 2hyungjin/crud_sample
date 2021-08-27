package com.example.server_exam.service

import com.example.server_exam.domain.dto.LoginDto
import com.example.server_exam.domain.dto.RegisterDto
import com.example.server_exam.domain.response.BasicResponse
import com.example.server_exam.domain.response.DataResponse
import org.apache.catalina.User
import org.springframework.stereotype.Service

interface AccountService {
    fun register(registerDto: RegisterDto): BasicResponse
    fun login(loginDto: LoginDto): DataResponse<String>
    fun findUserById(id:String):User
}