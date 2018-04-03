package com.example.kotlinback.controller

import com.example.kotlinback.service.NameGenerator
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/generator")
class GeneratorController(private val nameGenerator: NameGenerator) {
    @GetMapping("/name")
    fun generateName(): String = nameGenerator(10)
}

