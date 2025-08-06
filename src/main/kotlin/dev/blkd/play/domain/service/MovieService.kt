package dev.blkd.play.domain.service

import dev.blkd.play.domain.repository.MovieRepository
import org.springframework.stereotype.Service

@Service
class MovieService(
    private val movieRepository: MovieRepository
) {
    fun getAll() = movieRepository.getAll()

    fun getById(id: Long) = movieRepository.getById(id)
}