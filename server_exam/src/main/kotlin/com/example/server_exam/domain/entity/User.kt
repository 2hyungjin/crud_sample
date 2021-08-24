package com.example.server_exam.domain.entity

import com.example.server_exam.domain.dto.RegisterDto
import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
data class User(
    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val uId: Long?,
    @Column
    val id: String?,
    @Column
    val password: String?,
    @Column
    val name: String?,

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "uId")
    val boardList: List<Board>

) {
    constructor() : this(null, null, null, null, emptyList())
    constructor(id: String, password: String, name: String) : this(null, id, password, name, emptyList())
    constructor(registerDto: RegisterDto) : this(
        null,
        registerDto.id,
        registerDto.password,
        registerDto.name,
        emptyList()
    )
}
