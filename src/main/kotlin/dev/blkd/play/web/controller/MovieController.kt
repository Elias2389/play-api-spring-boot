package dev.blkd.play.web.controller

import dev.blkd.play.domain.dto.MovieDto
import dev.blkd.play.domain.service.MovieService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class MovieController(
    private val movieService: MovieService,
) {

    @GetMapping("/movies")
    fun getAll(): List<MovieDto> {
        return movieService.getAll()
    }

    @GetMapping("/movies/{id}")
    fun getById(
        @PathVariable id: Long,
    ): ResponseEntity<MovieDto?> {
        return movieService.getById(id)?.let { movie ->
            ResponseEntity.ok(movie)
        } ?: ResponseEntity.notFound().build()
    }
}
