package dev.blkd.play.domain.dto

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
    val title: String,
    val releaseYear: LocalDate? = null,
    val rating: BigDecimal? = null,
)

