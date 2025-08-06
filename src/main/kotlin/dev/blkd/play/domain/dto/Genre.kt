package dev.blkd.play.domain.dto

enum class Genre {
    ACTION,
    COMEDY,
    DRAMA,
    ANIMATED,
    HORROR,
    SCI_FI,
}

fun String.toGenre(): Genre = when (this.uppercase()) {
    "ACCION" -> Genre.ACTION
    "COMEDIA" -> Genre.COMEDY
    "DRAMA" -> Genre.DRAMA
    "TERROR" -> Genre.HORROR
    "ANIMADA" -> Genre.ANIMATED
    "CIENCIA_FICCION" -> Genre.SCI_FI
    else -> Genre.ACTION
}

fun Genre.toStringName(): String = when (this.name) {
    Genre.ACTION.name -> "ACCION"
    Genre.COMEDY.name -> "COMEDIA"
    Genre.DRAMA.name -> "DRAMA"
    Genre.HORROR.name -> "TERROR"
    Genre.ANIMATED.name -> "ANIMADA"
    Genre.SCI_FI.name -> "CIENCIA_FICCION"
    else -> "ACCION"
}