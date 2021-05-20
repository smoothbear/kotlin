package com.smoothbear.kotlin.global.error

enum class ErrorCode(
    val status: Int,
    val code: String,
    val message: String
) {
    // Global error code
    INVALID_INPUT_VALUE(status = 400, code = "G-4000", message = "Invalid input value."),
    INVALID_ENUM_TYPE(status = 400, code = "G-4001", message = "Invalid enum type."),

    METHOD_NOT_ALLOWED(status = 405, code = "G-4050", message = "Method is not allowed."),

    INTERNAL_SERVER_ERROR(status = 500, code = "G-5000", message = "Something went wrong."),

    // User error code
    USER_ALREADY_EXISTS(status = 409, code = "U-4090", message = "User is already exists."),
}