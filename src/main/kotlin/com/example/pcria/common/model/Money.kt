package com.example.pcria.common.model

class Money(
    val value: Int
) {
    fun plus(amounts: Money): Money {
        return Money(value + amounts.value)
    }

    fun minus(amounts: Money): Money {
        if (isLessThan(amounts)) {
            throw IllegalArgumentException("금액이 부족합니다.")
        }
        return Money(value - amounts.value)
    }

    private fun isLessThan(amounts: Money): Boolean {
        return value < amounts.value
    }
}