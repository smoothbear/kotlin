package com.smoothbear.kotlin.domain.user.repository

import com.smoothbear.kotlin.domain.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, String>