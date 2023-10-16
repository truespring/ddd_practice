package com.example.pcria.payment.common.model

class Money(
    val value: Int
) {
    fun plus(amounts: Money): Money {
        return Money(value + amounts.value)
    }
}