package dev.pfilaretov42.spring.mapstruct.mapper

import dev.pfilaretov42.spring.mapstruct.dto.PersonDto
import dev.pfilaretov42.spring.mapstruct.model.Person
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface PersonMapper {
    fun toModel(dto: PersonDto): Person
    fun toDto(model: Person): PersonDto
}