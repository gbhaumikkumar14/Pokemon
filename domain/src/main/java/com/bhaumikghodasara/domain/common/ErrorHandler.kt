package com.bhaumikghodasara.domain.common

interface ErrorHandler {
    fun getError(throwable: Throwable): ErrorEntity
}