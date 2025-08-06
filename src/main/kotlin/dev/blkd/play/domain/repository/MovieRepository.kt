package dev.blkd.play.domain.repository

import dev.blkd.play.domain.dto.MovieDto
import dev.blkd.play.domain.dto.UpdateMovieDto

interface MovieRepository {
    fun getAll(): List<MovieDto>
    fun getById(id: Long): MovieDto?
    fun save(movieDto: MovieDto): MovieDto
    fun removeById(id: Long)
    fun updateById(id: Long, updateMovieDto: UpdateMovieDto): MovieDto?
}