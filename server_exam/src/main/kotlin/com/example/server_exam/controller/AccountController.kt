package com.example.server_exam.controller

import com.example.server_exam.domain.dto.LoginDto
import com.example.server_exam.domain.dto.RegisterDto
import com.example.server_exam.domain.response.BasicResponse
import com.example.server_exam.domain.response.DataResponse
import com.example.server_exam.service.AccountService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping
class AccountController {
    @Autowired
    lateinit var accountService: AccountService

    @PostMapping("/register")
    fun register(
        @RequestBody registerDto: RegisterDto
    ): BasicResponse {
        return accountService.register(registerDto)
    }

    @PostMapping("/login")
    fun login(
        @RequestBody loginDto: LoginDto
    ): DataResponse<String> {
        return accountService.login(loginDto)
    }
}