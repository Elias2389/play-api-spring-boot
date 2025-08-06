package dev.blkd.play.web.exception

data class Error(
    val type: String? = null,
    val message: String,
)
