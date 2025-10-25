package dev.pfilaretov42.spring.mapstruct.model

class Balrog(
    val millenniaOld: Int,
    val trueName: TrueName,
    val battleName: String,
)

class TrueName(val value: String)