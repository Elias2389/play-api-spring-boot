package dev.blkd.play.persistence.repository

import dev.blkd.play.domain.dto.MovieDto
import dev.blkd.play.domain.dto.UpdateMovieDto
import dev.blkd.play.domain.exception.MovieAlreadyExisteException
import dev.blkd.play.domain.exception.MovieNotExistException
import dev.blkd.play.domain.repository.MovieRepository
import dev.blkd.play.persistence.crud.CrudMovieEntity
import dev.blkd.play.persistence.mapper.toDto
import dev.blkd.play.persistence.mapper.toEntity
import org.springframework.stereotype.Repository
import kotlin.jvm.optionals.getOrNull

@Repository
class MovieRepositoryImpl(
    private val crudMovieEntity: CrudMovieEntity
) : MovieRepository {
    override fun getAll(): List<MovieDto> {
        val response = crudMovieEntity.findAll().map { it.toDto() }
        return response
    }

    override fun getById(id: Long): MovieDto? {
        return crudMovieEntity.findById(id).getOrNull()?.toDto()
    }

    override fun save(movieDto: MovieDto): MovieDto {
        if (crudMovieEntity.findFirstByTitle(movieDto.title) == null) {
            throw MovieAlreadyExisteException(movieDto.title)
        }

        val movie = movieDto.toEntity().apply {
            state = "D"
        }
        return crudMovieEntity.save(movie).toDto()
    }

    override fun removeById(id: Long) {

    }

    override fun updateById(id: Long, updateMovieDto: UpdateMovieDto): MovieDto? {
        if (crudMovieEntity.findFirstByTitle(updateMovieDto.title) == null) {
            throw MovieNotExistException(updateMovieDto.title)
        }

       val movie = crudMovieEntity.findById(id).getOrNull()?.apply {
           title = updateMovieDto.title
           releaseYear = updateMovieDto.releaseYear
           classification = updateMovieDto.rating
       }

        if (movie == null) return null

        return crudMovieEntity.save(movie).toDto()
    }
}