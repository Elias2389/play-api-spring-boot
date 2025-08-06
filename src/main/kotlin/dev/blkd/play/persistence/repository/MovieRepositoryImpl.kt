package dev.blkd.play.persistence.repository

import dev.blkd.play.domain.dto.MovieDto
import dev.blkd.play.domain.repository.MovieRepository
import dev.blkd.play.persistence.crud.CrudMovieEntity
import dev.blkd.play.persistence.mapper.toDto
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

    override fun add(movieDto: MovieDto) {

    }

    override fun removeById(id: Long) {

    }

    override fun updateById(id: Long, movieDto: MovieDto) {

    }
}