package com.example.server_exam.service

import com.example.server_exam.domain.dto.LoginDto
import com.example.server_exam.domain.dto.RegisterDto
import com.example.server_exam.domain.entity.User
import com.example.server_exam.domain.response.BasicResponse
import com.example.server_exam.domain.response.DataResponse
import com.example.server_exam.error.IdOverlapException
import com.example.server_exam.error.RegisterException
import com.example.server_exam.respsitory.AccountRepository
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import javassist.NotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.client.HttpServerErrorException
import java.util.*
import javax.servlet.http.Cookie

@Service
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

    override fun login(loginDto: LoginDto): DataResponse<String> {
        var user: User?
        try {
            user = accountRepository.findById(loginDto.id)
        } catch (e: Exception) {
            throw HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR)
        }

        if (user == null) throw NotFoundException("해당 유저가 존재하지 않습니다.")
        else if (!user.password.equals(loginDto.password)) throw NotFoundException("비밀번호가 다릅니다")

//        val jwt =
//            Jwts.builder().setIssuer(user.id).setExpiration(Date(System.currentTimeMillis() + 60 * 24 * 1000))
//                .signWith(SignatureAlgorithm.ES512, "dazai0samu").compact()
        return DataResponse<String>(HttpStatus.OK, "로그인", "jwt")
    }
}