package com.example.server_exam.service

import com.example.server_exam.domain.dto.LoginDto
import com.example.server_exam.domain.dto.RegisterDto
import com.example.server_exam.domain.response.BasicResponse
import org.springframework.stereotype.Service

@Service
interface AccountService {
    fun save(registerDto: RegisterDto): BasicResponse
    fun login(loginDto: LoginDto): BasicResponse
}