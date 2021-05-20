package com.smoothbear.kotlin.global.error

class ErrorResponse(errorCode: ErrorCode) {
    private val status: Int = errorCode.status
    private val message: String = errorCode.message
    private val code: String = errorCode.code
}