package com.example.server_exam.domain.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
data class Board(
    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val uId: Long?,

    @Column
    val title: String,

    @Column
    val content: String,

    @ManyToOne
    @JoinColumn(name = "user_id")
    val writer: User?
) {
    constructor(title: String, content: String) : this(null, title, content, null)
}
