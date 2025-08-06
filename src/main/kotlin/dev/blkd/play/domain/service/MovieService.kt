package dev.blkd.play.domain.service

import dev.blkd.play.domain.dto.MovieDto
import dev.blkd.play.domain.dto.UpdateMovieDto
import dev.blkd.play.domain.repository.MovieRepository
import dev.langchain4j.agent.tool.Tool
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

    @Tool("Busca todas las peliculas que existan dentro de la plataforma")
    fun getAll() = movieRepository.getAll()

    fun getById(id: Long) = movieRepository.getById(id)
}