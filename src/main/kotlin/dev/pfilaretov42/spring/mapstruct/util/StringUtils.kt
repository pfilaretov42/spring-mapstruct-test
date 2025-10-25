package dev.pfilaretov42.spring.mapstruct.util

/**
 * Separate util object (do not list it in @Mapper(uses = ...))
 */
object StringUtils {
    @JvmStatic
    fun uppercased(s: String): String = s.uppercase()
}