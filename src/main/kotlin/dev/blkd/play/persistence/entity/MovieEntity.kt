package dev.blkd.play.persistence.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.math.BigDecimal
import java.time.LocalDate

@Entity(name = "play_movies")
class MovieEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    @Column(unique = true, nullable = false, length = 150)
    var title: String,
    @Column(nullable = false, precision = 3)
    var duration: Int,
    @Column(nullable = false, length = 40)
    var genre: String,
    @Column(name = "release_year")
    var releaseYear: LocalDate,
    @Column(precision = 3, scale = 2)
    var classification: BigDecimal,
    @Column(nullable = false, length = 1)
    var state: String
)