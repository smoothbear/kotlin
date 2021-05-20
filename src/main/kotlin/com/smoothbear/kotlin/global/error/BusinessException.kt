package com.smoothbear.kotlin.global.error

open class BusinessException(
    val errorCode: ErrorCode,
) : RuntimeException(errorCode.message)