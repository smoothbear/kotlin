package com.smoothbear.kotlin.domain.user.service

import com.smoothbear.kotlin.domain.user.controller.dto.RegisterReq
import com.smoothbear.kotlin.domain.user.exception.UserAlreadyExistsException
import com.smoothbear.kotlin.domain.user.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserServiceImpl (
    private val userRepository: UserRepository
) : UserService {
    override fun register(req: RegisterReq) {
        if (userRepository.findById(req.email).isPresent)
            throw UserAlreadyExistsException()

        userRepository.save(req.toEntity())
    }
}