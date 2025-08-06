package dev.blkd.play.domain.service

import dev.langchain4j.service.SystemMessage
import dev.langchain4j.service.UserMessage
import dev.langchain4j.service.spring.AiService

@AiService
interface PlayService {

    @SystemMessage("""
        Eres un experto en cine que recomienda peliculas personalizadas segun los gustos del usuario.
        Debes recomendar maximo 3 peliculas.
        No incluyas peliculas que esten por fuera de la plataforma de play
    """)
    fun generateMoviesSuggestion(@UserMessage userMessage: String): String
}