package com.example.kotlinback.controller

import com.example.kotlinback.model.Enclosure
import com.example.kotlinback.model.Zoo
import com.example.kotlinback.repository.EnclosureRepository
import com.example.kotlinback.repository.ZooRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class ZooController(private val enclosureRepository: EnclosureRepository, private val zooRepository: ZooRepository) {
    @GetMapping("/zoos")
    fun getAllZoos(): List<Zoo> = zooRepository.findAll()

    @GetMapping("/zoos/{id}")
    fun getZooById(@PathVariable("id") zooId: Long): ResponseEntity<Zoo> {
        return zooRepository.findById(zooId)
            .map { zoo -> ResponseEntity.ok(zoo) }
            .orElse(ResponseEntity.notFound().build<Zoo>())
    }

    @PostMapping("/zoos")
    fun createNewZoo(@Valid @RequestBody zoo: Zoo): Zoo = zooRepository.save(zoo)

    @PostMapping("/zoos/{id}/enclosures")
    fun createNewEnclosure(@PathVariable("id") zooId: Long,
                           @Valid @RequestBody enclosure: Enclosure): Enclosure {
        enclosure.zoo = Zoo(id = zooId)
        return enclosureRepository.save(enclosure)
    }

    @PutMapping("/zoos/{id}")
    fun updateZooById(@PathVariable("id") zooId: Long,
                      @Valid @RequestBody zoo: Zoo): ResponseEntity<Zoo> {
        return zooRepository.findById(zooId).map { existingZoo ->
            val updatedZoo: Zoo = existingZoo.copy(name = zoo.name)
            ResponseEntity.ok().body(zooRepository.save(updatedZoo))
        }.orElse(ResponseEntity.notFound().build())
    }

    @DeleteMapping("/zoos/{id}")
    fun deleteZooById(@PathVariable("id") zooId: Long): ResponseEntity<Void> {
        return zooRepository.findById(zooId).map { zoo ->
            zooRepository.delete(zoo)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
    }
}
