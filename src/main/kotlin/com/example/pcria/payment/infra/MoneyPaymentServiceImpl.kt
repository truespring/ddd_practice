package com.example.pcria.payment.infra

import com.example.pcria.payment.command.domain.MoneyPaymentService
import com.example.pcria.payment.query.dto.MoneyPaymentDto
import com.example.pcria.payment.query.MoneyPaymentResponse
import org.springframework.stereotype.Service

@Service
class MoneyPaymentServiceImpl: MoneyPaymentService {
    override fun payment(request: MoneyPaymentDto): MoneyPaymentResponse {
        return MoneyPaymentResponse(true)
    }
}