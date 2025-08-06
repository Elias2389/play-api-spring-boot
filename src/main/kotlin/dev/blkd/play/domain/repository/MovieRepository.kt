package dev.blkd.play.domain.repository

import dev.blkd.play.domain.dto.MovieDto

interface MovieRepository {
    fun getAll(): List<MovieDto>
    fun getById(id: Long): MovieDto?
    fun add(movieDto: MovieDto)
    fun removeById(id: Long)
    fun updateById(id: Long, movieDto: MovieDto)
}