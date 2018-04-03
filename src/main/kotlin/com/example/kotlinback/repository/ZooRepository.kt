package com.example.kotlinback.repository

import com.example.kotlinback.model.Zoo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ZooRepository : JpaRepository<Zoo, Long>
