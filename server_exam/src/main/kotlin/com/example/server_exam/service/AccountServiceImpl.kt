package com.example.server_exam.service

import com.example.server_exam.domain.dto.LoginDto
import com.example.server_exam.domain.dto.RegisterDto
import com.example.server_exam.domain.entity.User
import com.example.server_exam.domain.response.BasicResponse
import com.example.server_exam.respsitory.AccountRepository
import org.apache.coyote.Response
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus

class AccountServiceImpl : AccountService {
    @Autowired
    lateinit var accountRepository: AccountRepository

    override fun save(registerDto: RegisterDto): BasicResponse {
        val newUser = User(registerDto)
        accountRepository.save(newUser)
        return BasicResponse(HttpStatus.OK, "회원가입")
    }

    override fun login(loginDto: LoginDto): BasicResponse {
        accountRepository.findByIdAndPassword()
        return BasicResponse(HttpStatus.OK,"로그인")
    }
}