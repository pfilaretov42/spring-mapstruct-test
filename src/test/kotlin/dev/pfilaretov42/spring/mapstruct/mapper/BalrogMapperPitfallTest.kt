package dev.pfilaretov42.spring.mapstruct.mapper

import dev.pfilaretov42.spring.mapstruct.dto.BalrogDto
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

/**
 * This test intentionally demonstrates a MapStruct pitfall.
 *
 * We use a protected String->String method only in an expression for the 'trueName' field,
 * but MapStruct will also apply it automatically to other String fields (battleName),
 * because it discovers the method by its (String -> String) signature and considers it
 * a general-purpose mapping.
 *
 * EXPECTATION (what we want):
 *  - only 'trueName' should be uppercased
 *  - 'battleName' should remain unchanged
 *
 * ACTUAL (what MapStruct does):
 *  - both 'trueName' and 'battleName' become uppercased
 */
@SpringBootTest
class BalrogMapperPitfallTest {

    @Autowired
    lateinit var mapper: BalrogMapper

    @Test
    fun `should not change other String fields when using expression on trueName only`() {
        // given
        val dto = BalrogDto(
            millenniaOld = 20,
            trueName = "Gothmog",
            battleName = "High Captain of Angband"
        )

        // when
        val model = mapper.toModel(dto)

        // then
        assertEquals("GOTHMOG", model.trueName, "trueName should be uppercased via expression")
        // We expect battleName to be unchanged, but due to the pitfall it becomes uppercased.
        // This assertion will FAIL, showcasing the issue.
        assertEquals(
            "High Captain of Angband",
            model.battleName,
            "battleName should NOT be affected by the expression on 'trueName'"
        )
    }
}
