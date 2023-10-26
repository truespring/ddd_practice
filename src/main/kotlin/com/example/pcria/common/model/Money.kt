package com.example.pcria.common.model

class Money(
    val amount: Int
) {
    companion object {
        @JvmStatic
        val ZERO = wons(0)

        @JvmStatic
        fun wons(value: Int): Money = Money(value)
    }

    fun plus(amounts: Money): Money = Money(amount + amounts.amount)

    fun minus(amounts: Money) {
        when (isLessThan(amounts)) {
            true -> throw IllegalArgumentException("금액이 부족합니다.")
            false -> Money(amount - amounts.amount)
        }
    }

    private fun isLessThan(amounts: Money): Boolean = amount < amounts.amount
}