package com.example.server_exam.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class AccountController {
    @GetMapping("/login")
    fun login(): String {
        return "aa"
    }
    @GetMapping("/login22")
    fun login22(): String {
        return "bb"
    }
}