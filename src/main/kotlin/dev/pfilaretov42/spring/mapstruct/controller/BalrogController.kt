package dev.pfilaretov42.spring.mapstruct.controller

import dev.pfilaretov42.spring.mapstruct.dto.BalrogDto
import dev.pfilaretov42.spring.mapstruct.mapper.BalrogMapper
import dev.pfilaretov42.spring.mapstruct.service.BalrogService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/balrogs")
class BalrogController(
    private val balrogService: BalrogService,
    private val balrogMapper: BalrogMapper,
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody dto: BalrogDto): BalrogDto {
        val model = balrogMapper.toModel(dto)
        val saved = balrogService.create(model)
        return balrogMapper.toDto(saved)
    }
}