package com.example.server_exam.respsitory

import com.example.server_exam.domain.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AccountRepository : JpaRepository<User, Long> {
    fun findById(id: String): User?
}