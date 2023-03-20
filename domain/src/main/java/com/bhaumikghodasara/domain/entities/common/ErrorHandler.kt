package com.bhaumikghodasara.domain.entities.common

interface ErrorHandler {
    fun getError(throwable: Throwable): ErrorEntity
}