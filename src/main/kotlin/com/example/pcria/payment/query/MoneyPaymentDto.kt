package com.example.pcria.payment.query

import com.example.pcria.common.model.Money

data class MoneyPaymentDto(
    private var amount: Int
) {
    companion object {
        @JvmStatic
        fun of(value: Money): MoneyPaymentDto = MoneyPaymentDto(value.amount)
    }
}