package dev.blkd.play.web.exception

import dev.blkd.play.domain.exception.MovieAlreadyExisteException
import dev.blkd.play.domain.exception.MovieNotExistException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class RestExceptionHandler {

    @ExceptionHandler(MovieAlreadyExisteException::class)
    fun handleException(exception: Exception): ResponseEntity<Error> {
        val error = Error(message = exception.message ?: "Unknown error", type = "movie-al-ready-exist")
        return ResponseEntity.badRequest().body(error)
    }

    @ExceptionHandler(MovieNotExistException::class)
    fun handleExceptionMovieNotExistException(exception: Exception): ResponseEntity<Error> {
        val error = Error(message = exception.message ?: "Unknown error", type = "movie-not-exist")
        return ResponseEntity.badRequest().body(error)
    }
}
