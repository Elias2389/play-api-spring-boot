package dev.blkd.play

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PlayMoviesApplication

fun main(args: Array<String>) {
	runApplication<PlayMoviesApplication>(*args)
}
