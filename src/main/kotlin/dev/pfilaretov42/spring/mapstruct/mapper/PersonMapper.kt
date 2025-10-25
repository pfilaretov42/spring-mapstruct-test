package dev.pfilaretov42.spring.mapstruct.mapper

import dev.pfilaretov42.spring.mapstruct.dto.PersonDto
import dev.pfilaretov42.spring.mapstruct.model.Person
import org.mapstruct.Mapper
import org.mapstruct.Mapping

/**
 * Demonstrates a pitfall: a protected String->String mapping method is introduced and
 * explicitly used only for the 'name' field via expression. However, MapStruct will
 * discover it by signature and may use it for other String fields (e.g. nickName) as well.
 */
@Mapper(componentModel = "spring")
abstract class PersonMapper {

    @Mapping(target = "name", expression = "java(uppercased(dto.getName()))")
    abstract fun toModel(dto: PersonDto): Person

    // This is the tricky method: it looks generic (String -> String), so MapStruct can pick it up
    // and use it for ANY String mapping, not only where we want it.
    protected fun uppercased(value: String): String = value.uppercase()

    abstract fun toDto(model: Person): PersonDto
}
