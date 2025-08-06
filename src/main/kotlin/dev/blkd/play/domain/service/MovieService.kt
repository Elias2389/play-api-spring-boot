package dev.blkd.play.domain.service

import dev.blkd.play.domain.dto.MovieDto
import dev.blkd.play.domain.dto.UpdateMovieDto
import dev.blkd.play.domain.repository.MovieRepository
import org.springframework.stereotype.Service

@Service
class MovieService(
    private val movieRepository: MovieRepository
) {
    fun add(movieDto: MovieDto): MovieDto {
        return movieRepository.save(movieDto)
    }

    fun update(
        id: Long,
        updateMovieDto: UpdateMovieDto
    ): MovieDto? = movieRepository.updateById(id, updateMovieDto)

    fun getAll() = movieRepository.getAll()

    fun getById(id: Long) = movieRepository.getById(id)
}