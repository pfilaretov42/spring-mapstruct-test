package dev.pfilaretov42.spring.mapstruct.mapper

import dev.pfilaretov42.spring.mapstruct.dto.BalrogDto
import dev.pfilaretov42.spring.mapstruct.model.Balrog
import dev.pfilaretov42.spring.mapstruct.model.TrueName
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

    abstract fun toModel(dto: BalrogDto): Balrog

    fun toTrueName(raw: String): TrueName = TrueName(raw.uppercase())

    fun fromTrueName(name: TrueName): String = name.value

    abstract fun toDto(model: Balrog): BalrogDto
}
