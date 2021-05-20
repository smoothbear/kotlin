package com.smoothbear.kotlin.domain.user.domain

import javax.persistence.*

@Entity
@Table(name = "users")
class User (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false, unique = true)
    val email: String,

    @Column(nullable = false)
    val password: String,

    @Column(nullable = false)
    val name: String
)