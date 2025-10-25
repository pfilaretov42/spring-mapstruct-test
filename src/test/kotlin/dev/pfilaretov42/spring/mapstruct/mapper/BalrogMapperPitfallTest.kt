package dev.pfilaretov42.spring.mapstruct.mapper

import dev.pfilaretov42.spring.mapstruct.dto.BalrogDto
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

/**
 * This test intentionally demonstrates a MapStruct pitfall.
 *
 * We use a protected String->String method only in an expression for the 'name' field,
 * but MapStruct will also apply it automatically to other String fields (nickName),
 * because it discovers the method by its (String -> String) signature and considers it
 * a general-purpose mapping.
 *
 * EXPECTATION (what we want):
 *  - only 'name' should be uppercased
 *  - 'nickName' should remain unchanged
 *
 * ACTUAL (what MapStruct does):
 *  - both 'name' and 'nickName' become uppercased
 */
@SpringBootTest
class BalrogMapperPitfallTest {

    @Autowired
    lateinit var mapper: BalrogMapper

    @Test
    fun `should not change other String fields when using expression on name only`() {
        // given
        val dto = BalrogDto(
            age = 20,
            name = "Jimmy",
            nickName = "Big Jim"
        )

        // when
        val model = mapper.toModel(dto)

        // then
        assertEquals("JIMMY", model.name, "Name should be uppercased via expression")
        // We expect nickName to be unchanged, but due to the pitfall it becomes uppercased.
        // This assertion will FAIL, showcasing the issue.
        assertEquals("Big Jim", model.nickName, "nickName should NOT be affected by the expression on 'name'")
    }
}
