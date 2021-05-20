package com.smoothbear.kotlin.global.error

import com.smoothbear.kotlin.global.log.Log
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindException
import org.springframework.web.HttpRequestMethodNotSupportedException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException

@ControllerAdvice
class GlobalExceptionHandler {
    companion object: Log()

    @ExceptionHandler(BusinessException::class)
    protected fun businessException(e: BusinessException): ResponseEntity<ErrorResponse> {
        logger.error("Business error: ", e)
        val response = ErrorResponse(e.errorCode)

        return ResponseEntity(response, HttpStatus.valueOf(e.errorCode.status))
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    protected fun methodNotValidException(e: MethodArgumentNotValidException): ResponseEntity<ErrorResponse> {
        logger.error("Binding error: ", e)
        val response = ErrorResponse(ErrorCode.INVALID_INPUT_VALUE)

        return ResponseEntity(response, HttpStatus.valueOf(ErrorCode.INVALID_INPUT_VALUE.status))
    }

    @ExceptionHandler(BindException::class)
    protected fun bindException(e: BindException): ResponseEntity<ErrorResponse> {
        logger.error("Binding error: ", e)
        val response = ErrorResponse(ErrorCode.INVALID_INPUT_VALUE)

        return ResponseEntity(response, HttpStatus.valueOf(ErrorCode.INVALID_INPUT_VALUE.status))
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException::class)
    protected fun argumentTypeMisMatchException(e: MethodArgumentTypeMismatchException): ResponseEntity<ErrorResponse> {
        logger.error("Enum type mismatch: ", e)
        val response = ErrorResponse(ErrorCode.INVALID_ENUM_TYPE)

        return ResponseEntity(response, HttpStatus.valueOf(ErrorCode.INVALID_ENUM_TYPE.status))
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException::class)
    protected fun requestMethodNotSupportedException(e: HttpRequestMethodNotSupportedException): ResponseEntity<ErrorResponse> {
        logger.error("Http request method error: ", e)
        val response = ErrorResponse(ErrorCode.METHOD_NOT_ALLOWED)

        return ResponseEntity(response, HttpStatus.valueOf(ErrorCode.METHOD_NOT_ALLOWED.status))
    }

    @ExceptionHandler(Exception::class)
    protected fun anyException(e: Exception): ResponseEntity<ErrorResponse> {
        logger.error("Internal error: ", e)
        val response = ErrorResponse(ErrorCode.INTERNAL_SERVER_ERROR)

        return ResponseEntity(response, HttpStatus.valueOf(ErrorCode.INTERNAL_SERVER_ERROR.status))
    }
}