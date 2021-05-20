package com.smoothbear.kotlin.domain.user.exception

import com.smoothbear.kotlin.global.error.BusinessException
import com.smoothbear.kotlin.global.error.ErrorCode

class UserAlreadyExistsException : BusinessException(ErrorCode.USER_ALREADY_EXISTS)