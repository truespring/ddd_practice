package com.example.pcria.payment.infra

import com.example.pcria.payment.command.domain.MoneyPaymentService
import com.example.pcria.payment.query.MoneyPaymentDto
import com.example.pcria.payment.query.MoneyPaymentResponse
import org.springframework.stereotype.Service

@Service
class MoneyPaymentServiceImpl: MoneyPaymentService {
    override fun payment(request: MoneyPaymentDto): MoneyPaymentResponse {
        TODO("Not yet implemented")
    }
}