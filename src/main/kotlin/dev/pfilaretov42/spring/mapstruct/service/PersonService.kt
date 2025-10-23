package dev.pfilaretov42.spring.mapstruct.service

import dev.pfilaretov42.spring.mapstruct.model.Person
import org.springframework.stereotype.Service

@Service
class PersonService {
    fun create(person: Person): Person {
        // In a real app, persist and return saved entity; here we just echo back
        return person
    }
}