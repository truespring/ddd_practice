package com.example.pcria.common.model

data class Money(
    val amount: Int
) {
    companion object {
        @JvmStatic
        val ZERO = wons(0)

        @JvmStatic
        fun wons(value: Int): Money = Money(value)
    }

    operator fun plus(amount: Money): Money = Money(this.amount + amount.amount)

    operator fun minus(amount: Money) {
        when (isLessThan(amount)) {
            true -> throw IllegalArgumentException("금액이 부족합니다.")
            false -> Money(this.amount - amount.amount)
        }
    }

    private fun isLessThan(amount: Money): Boolean = this.amount < amount.amount
}