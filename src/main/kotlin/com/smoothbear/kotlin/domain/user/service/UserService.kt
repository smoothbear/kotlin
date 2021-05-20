package com.smoothbear.kotlin.domain.user.service

import com.smoothbear.kotlin.domain.user.controller.dto.RegisterReq

interface UserService {
    fun register(req: RegisterReq)
}