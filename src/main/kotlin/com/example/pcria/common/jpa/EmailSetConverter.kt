package com.example.pcria.common.jpa

import com.example.pcria.common.model.Email
import com.example.pcria.common.model.EmailSet
import jakarta.persistence.AttributeConverter
import jakarta.persistence.Converter
import java.util.stream.Collectors
import java.util.stream.Collectors.toSet

@Converter
class EmailSetConverter : AttributeConverter<EmailSet, String> {
    override fun convertToDatabaseColumn(attribute: EmailSet?): String {
        return when (attribute) {
            null -> ""
            else -> attribute.emails().stream()
                .map { email -> email.address() }
                .collect(Collectors.joining(","))
        }
    }

    override fun convertToEntityAttribute(dbData: String?): EmailSet {
        return when (dbData) {
            null -> EmailSet(setOf())
            else -> EmailSet(dbData.split(",").stream()
                .map { value -> Email.of(value) }
                .collect(toSet()))
        }
    }
}