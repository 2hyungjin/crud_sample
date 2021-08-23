package com.example.server_exam.domain.entity

import javax.persistence.*

@Entity
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val uId: Long?,
    @Column
    val id: String,
    @Column
    val password: String,
    @Column
    val name: String,

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "uId")
    val boardList: List<Board>

) {
    constructor(id: String, password: String, name: String) : this(null, id, password, name, emptyList())
}