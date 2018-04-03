package com.example.kotlinback.repository

import com.example.kotlinback.model.Enclosure
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface EnclosureRepository : JpaRepository<Enclosure, Long>
