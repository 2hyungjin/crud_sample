package com.example.server_exam.service

import com.example.server_exam.domain.dto.LoginDto
import com.example.server_exam.domain.dto.RegisterDto
import com.example.server_exam.domain.entity.User
import com.example.server_exam.domain.response.BasicResponse
import com.example.server_exam.error.IdOverlapException
import com.example.server_exam.error.RegisterException
import com.example.server_exam.respsitory.AccountRepository
import javassist.NotFoundException
import org.apache.coyote.Response
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.client.HttpServerErrorException

class AccountServiceImpl : AccountService {
    @Autowired
    lateinit var accountRepository: AccountRepository

    override fun register(registerDto: RegisterDto): BasicResponse {
        val newUser = User(registerDto)
        try {
            accountRepository.save(newUser)
        } catch (e: Exception) {
            throw RegisterException("회원가입 실패")
        }
        return BasicResponse(HttpStatus.OK, "회원가입")
    }

    override fun checkId(id: String): BasicResponse {
        var idIsAvailable: Boolean
        try {
            idIsAvailable = accountRepository.findByIdIsNull(id)
        } catch (e: Exception) {
            throw HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR)
        }
        if (!idIsAvailable) throw IdOverlapException("중복된 아이디")
        return BasicResponse(HttpStatus.OK, "사용 가능한 아이디")
    }

    override fun login(loginDto: LoginDto): BasicResponse {
        var user: User?
        try {
            user = accountRepository.findById(loginDto.id)
        } catch (e: Exception) {
            throw HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR)
        }
        if (user == null) throw NotFoundException("해당 유저가 존재하지 않습니다.")
        else if (user.password.equals(loginDto.password)) throw NotFoundException("비밀번호가 다릅니다")
        return BasicResponse(HttpStatus.OK, "로그인")
    }
}