package dev.pfilaretov42.spring.mapstruct.service

import dev.pfilaretov42.spring.mapstruct.model.Balrog
import org.springframework.stereotype.Service

@Service
class BalrogService {
    fun create(balrog: Balrog): Balrog {
        // In a real app, persist and return saved entity; here we just echo back
        return balrog
    }
}