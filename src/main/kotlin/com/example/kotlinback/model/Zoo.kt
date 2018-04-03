package com.example.kotlinback.model

import javax.persistence.*
import javax.validation.constraints.NotEmpty

@Entity
data class Zoo(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0,

    @OneToMany(mappedBy = "zoo", fetch = FetchType.EAGER, cascade = arrayOf(CascadeType.ALL))
    val enclosures: List<Enclosure> = emptyList(),

    @NotEmpty
    val name: String = ""
)