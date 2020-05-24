package com.padovese.assessment.exception

import org.slf4j.Logger
import org.slf4j.event.Level
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class DefaultExceptionHandler(private val logger: Logger) {

    @ExceptionHandler(Exception::class)
    fun handleError(exception: Exception): ResponseEntity<ErrorResponse> {
        logException(exception.message.toString(), exception, Level.ERROR)
        return getDefaultResponseMessage(exception.message.toString(), HttpStatus.INTERNAL_SERVER_ERROR)
    }

    @ExceptionHandler(HttpMessageNotReadableException::class)
    fun handleJsonParseError(exception: HttpMessageNotReadableException): ResponseEntity<ErrorResponse> {
        logException(exception.message.toString(), exception, Level.WARN)
        return getDefaultResponseMessage("Invalid JSON.", HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(NegativeArgException::class)
    fun handleNegativeArgException(exception: NegativeArgException): ResponseEntity<ErrorResponse> {
        logException(exception.message.toString(), exception, Level.WARN)
        return getDefaultResponseMessage(exception.message.toString(), HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(RiskQuestionsException::class)
    fun handleRiskQuestionsException(exception: RiskQuestionsException): ResponseEntity<ErrorResponse> {
        logException(exception.message.toString(), exception, Level.WARN)
        return getDefaultResponseMessage(exception.message.toString(), HttpStatus.BAD_REQUEST)
    }

    private fun logException(message: String, exception: Exception, level: Level = Level.INFO) {
        when (level) {
            Level.ERROR -> logger.error(message, exception)
            Level.INFO -> logger.info(message)
            else -> logger.warn(message)
        }
    }

    private fun getDefaultResponseMessage(message: String, httpStatus: HttpStatus): ResponseEntity<ErrorResponse> {
        val errorMessages = listOf(
                ErrorMessage(message = message)
        )
        return ResponseEntity(ErrorResponse(errorMessages), httpStatus)
    }

}