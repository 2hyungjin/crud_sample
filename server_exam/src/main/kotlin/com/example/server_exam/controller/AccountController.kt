package com.example.server_exam.controller

import com.example.server_exam.domain.dto.LoginDto
import com.example.server_exam.domain.dto.RegisterDto
import com.example.server_exam.domain.response.BasicResponse
import com.example.server_exam.service.AccountService
import org.apache.coyote.Response
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class AccountController {
    @Autowired
    lateinit var accountService: AccountService

    @PostMapping("/register")
    fun register(
        @RequestBody registerDto: RegisterDto
    ): BasicResponse {
        return accountService.save(registerDto)
    }

    @PostMapping("/login")
    fun login(
        @RequestBody loginDto: LoginDto
    ): BasicResponse {
        return accountService.login(loginDto)
    }
}