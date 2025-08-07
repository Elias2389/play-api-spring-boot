package dev.blkd.play.domain.dto

import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.PastOrPresent
import java.math.BigDecimal
import java.time.LocalDate

data class MovieDto(
    val id: Long? = null,
    val title: String,
    val duration: Int,
    val genre: Genre,
    val releaseYear: LocalDate? = null,
    val rating: BigDecimal? = null,
)


data class UpdateMovieDto(
    @field:NotBlank(message = "Title cannot be blank")
    val title: String,
    @field:PastOrPresent(message = "Release year must be in the past or present")
    val releaseYear: LocalDate? = null,
    @field:Min(value = 0, message = "Rating must be between 0 and 5")
    @field:Max(value = 5, message = "Rating must be between 0 and 5")
    val rating: BigDecimal? = null,
)

