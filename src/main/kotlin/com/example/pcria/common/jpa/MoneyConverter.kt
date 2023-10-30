package com.example.pcria.common.jpa

import com.example.pcria.common.model.Money
import jakarta.persistence.AttributeConverter
import jakarta.persistence.Converter

@Converter
class MoneyConverter : AttributeConverter<Money, Int> {
    override fun convertToDatabaseColumn(attribute: Money?): Int {
        return attribute?.amount ?: 0
    }

    override fun convertToEntityAttribute(dbData: Int?): Money =
        dbData?.let {
            Money.wons(it)
        } ?: Money.ZERO
}