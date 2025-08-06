package dev.blkd.play.persistence.mapper

import dev.blkd.play.domain.dto.MovieDto
import dev.blkd.play.domain.dto.toGenre
import dev.blkd.play.domain.dto.toStringName
import dev.blkd.play.persistence.entity.MovieEntity

fun MovieEntity.toDto() = MovieDto(
    id = id,
    title = title,
    duration = duration,
    genre = genre.toGenre(),
    releaseYear = releaseYear,
    rating = classification,
)

fun MovieDto.toEntity(): MovieEntity {
    val movieDto = this
    return MovieEntity().apply {
        this.id = movieDto.id
        this.title = movieDto.title
        this.duration = movieDto.duration
        this.genre = movieDto.genre.toStringName()
        this.releaseYear = movieDto.releaseYear
        this.classification = movieDto.rating
    }
}
