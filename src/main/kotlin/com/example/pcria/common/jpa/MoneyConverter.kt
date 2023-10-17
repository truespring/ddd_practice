package com.example.pcria.common.jpa

import com.example.pcria.common.model.Money
import jakarta.persistence.AttributeConverter

class MoneyConverter: AttributeConverter<Money, Int> {
    override fun convertToDatabaseColumn(attribute: Money?): Int {
        return attribute?.value ?: 0
    }

    override fun convertToEntityAttribute(dbData: Int?): Money {
        return dbData?.let {
            Money(it)
        } ?: Money(0)
    }
}