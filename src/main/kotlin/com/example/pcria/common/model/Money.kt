package com.example.pcria.common.model

data class Money(
    private var amount: Int
) {
    fun amount(): Int = this.amount

    companion object {
        @JvmStatic
        val ZERO = wons(0)

        @JvmStatic
        fun wons(value: Int): Money = Money(value)
    }

    operator fun plus(value: Money) {
        this.amount += value.amount
    }

    operator fun minus(amount: Money) {
        when (isLessThan(amount)) {
            true -> throw IllegalArgumentException("금액이 부족합니다.")
            false -> this.amount -= amount.amount
        }
    }
    operator fun times(percent: Double) = (this.amount * percent).toInt()
    operator fun times(quantity: Int) = this.amount * quantity
    private fun isLessThan(amount: Money): Boolean = this.amount < amount.amount
}