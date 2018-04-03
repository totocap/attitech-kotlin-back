package com.example.kotlinback.model

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotEmpty

@Entity
data class Enclosure(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0,

    val content: AnimalType = AnimalType.ZEBRA,

    @Min(0)
    @Max(10)
    val height: Int = 0,

    @Min(0)
    @Max(10)
    val width: Int = 5,

    @NotEmpty
    val animalName: String = "",

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "zoo_id")
    @get: JsonIgnore
    var zoo: Zoo? = null
) {
    override fun toString(): String = "Enclosure(id=$id, content=$content, height=$height, width=$width, animalName='$animalName', zoo=${zoo?.id})"
}