package com.example.kotlinback.service

import org.springframework.stereotype.Service
import java.util.*

@Service
class NameGenerator {
    private val vowels: String = "aeiouy"
    private val consonants: String

    init {
        consonants = CharArray(26) { 'a' + it }.filter { !vowels.contains(it) }.joinToString("")
    }

    operator fun invoke(length: Int): String {
        return CharArray(length) { if (it % 2 == 0) consonants.random() else vowels.random() }
            .joinToString("")
            .capitalize()
    }

    fun String.random(): Char = get(Random().nextInt(length))
}
