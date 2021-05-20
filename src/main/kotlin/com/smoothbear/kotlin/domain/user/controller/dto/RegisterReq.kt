package com.smoothbear.kotlin.domain.user.controller.dto

import com.smoothbear.kotlin.domain.user.domain.User

class RegisterReq (
    val email: String,
    private val password: String,
    private val name: String
) {
    fun toEntity(): User {
        return User(
            email = email,
            password = password,
            name = name
        )
    }
}