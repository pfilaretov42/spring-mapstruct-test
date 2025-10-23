package dev.pfilaretov42.spring.mapstruct.controller

import dev.pfilaretov42.spring.mapstruct.dto.PersonDto
import dev.pfilaretov42.spring.mapstruct.mapper.PersonMapper
import dev.pfilaretov42.spring.mapstruct.service.PersonService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/persons")
class PersonController(
    private val personService: PersonService,
    private val personMapper: PersonMapper,
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody dto: PersonDto): PersonDto {
        val model = personMapper.toModel(dto)
        val saved = personService.create(model)
        return personMapper.toDto(saved)
    }
}