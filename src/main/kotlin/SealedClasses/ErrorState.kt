package SealedClasses

sealed class ErrorState

class APIError(code: Int) : ErrorState()

data class DataBaseError(val dataError: Int) : ErrorState()

object CommonError : ErrorState()