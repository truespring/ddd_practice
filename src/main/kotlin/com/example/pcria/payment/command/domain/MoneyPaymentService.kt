package com.example.pcria.payment.command.domain

import com.example.pcria.payment.query.MoneyPaymentDto
import com.example.pcria.payment.query.MoneyPaymentResponse

fun interface MoneyPaymentService {
    fun payment(request: MoneyPaymentDto): MoneyPaymentResponse
}