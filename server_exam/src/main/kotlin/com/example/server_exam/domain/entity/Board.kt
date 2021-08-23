package com.example.server_exam.domain.entity

import javax.persistence.*

@Entity
data class Board(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val uId: Long?,

    @Column
    val title: String,

    @Column
    val content: String,

    @ManyToOne
    @JoinColumn(name = "user_id")
    val writer: User
)
