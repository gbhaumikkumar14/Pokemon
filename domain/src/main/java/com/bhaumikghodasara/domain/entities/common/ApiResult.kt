package com.bhaumikghodasara.domain.entities.common

/**
 * A generic class that holds a value or an error status.
 * @param <T>
 */
sealed class ApiResult<T>(
    val data: T? = null,
    val message: String? = null,
    val errorEntity: ErrorEntity? = null
) {
    class Success<T>(data: T) : ApiResult<T>(data)
    class Error<T>(message: String, data: T? = null, errorEntity: ErrorEntity? = null) :
        ApiResult<T>(data, message, errorEntity)

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[message=$message, data=$data, errorEntity=$errorEntity]"
        }
    }
}