package dev.blkd.play.domain.exception

class MovieAlreadyExisteException(
    val movieTitle: String
): RuntimeException("Movie '$movieTitle' already exists."
)

class MovieNotExistException(
    val movieTitle: String
): RuntimeException("Movie '$movieTitle' not exists."
)