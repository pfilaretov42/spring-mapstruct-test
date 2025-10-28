package dev.pfilaretov42.spring.mapstruct.mapper

import dev.pfilaretov42.spring.mapstruct.dto.BalrogDto
import dev.pfilaretov42.spring.mapstruct.model.Balrog
import org.mapstruct.Mapper
import org.mapstruct.Mapping

/**
 * Like a Balrog lurking in the depths of Moria, a seemingly harmless protected String->String
 * mapping method can unexpectedly emerge and set other String fields ablaze. We explicitly
 * use it only for the 'trueName' field via expression, but MapStruct may discover it by signature
 * and apply it to other String fields (e.g., battleName) as well.
 */
@Mapper(componentModel = "spring")
abstract class BalrogMapper {

    @Mapping(target = "trueName", expression = "java(uppercased(dto.getTrueName()))")
    abstract fun toModel(dto: BalrogDto): Balrog

    // This is the tricky method: it looks generic (String -> String), so MapStruct can pick it up
    // and use it for ANY String mapping, not only where we want it.
    protected fun uppercased(value: String): String = value.uppercase()

    abstract fun toDto(model: Balrog): BalrogDto
}
