package dev.blkd.play.web.controller

import dev.blkd.play.domain.dto.MovieDto
import dev.blkd.play.domain.dto.SuggestRequestDto
import dev.blkd.play.domain.dto.UpdateMovieDto
import dev.blkd.play.domain.service.MovieService
import dev.blkd.play.domain.service.PlayService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/movies")
@Tag(name = "Movies", description = "Movie related endpoints")
@io.swagger.v3.oas.annotations.security.SecurityRequirement(
    name = "bearerAuth"
)
class MovieController(
    private val movieService: MovieService,
    private val aiService: PlayService
) {

    @PostMapping("")
    fun add(
        @RequestBody movieDto: MovieDto
    ): ResponseEntity<MovieDto> {
        return ResponseEntity.status(HttpStatus.CREATED).body(
            movieService.add(movieDto)
        )
    }

    @PutMapping("/{id}")
    fun update(
        @PathVariable id: Long,
        @RequestBody @Valid updateMovieDto: UpdateMovieDto
    ): ResponseEntity<MovieDto> {
        return ResponseEntity.status(HttpStatus.OK).body(
            movieService.update(id, updateMovieDto)
        )
    }

    @GetMapping("")
    fun getAll(): List<MovieDto> {
        return movieService.getAll()
    }

    @GetMapping("/{id}")
    @Operation(
        summary = "Get movie by ID",
        description = "Returns a movie by its ID",
        responses = [
            ApiResponse(responseCode = "200", description = "Movie found"),
        ]
    )
    fun getById(
        @Parameter(description = "ID of the movie to be returned", example = "9")
        @PathVariable id: Long,
    ): ResponseEntity<MovieDto?> {
        return movieService.getById(id)?.let { movie ->
            ResponseEntity.ok(movie)
        } ?: ResponseEntity.notFound().build()
    }

    @PostMapping("/suggestn")
    fun getMoviesSuggestion(
        @RequestBody suggestion: SuggestRequestDto
    ): ResponseEntity<String> {
        return ResponseEntity
            .ok(aiService.generateMoviesSuggestion(suggestion.userPreferences))
    }

}
