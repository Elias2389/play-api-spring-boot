package dev.blkd.play.persistence.crud

import dev.blkd.play.persistence.entity.MovieEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CrudMovieEntity: CrudRepository<MovieEntity, Long> {
    fun findFirstByTitle(title: String): MovieEntity?
}