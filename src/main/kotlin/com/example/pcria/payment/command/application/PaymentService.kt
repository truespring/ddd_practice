package com.example.pcria.payment.command.application

import com.example.pcria.payment.command.domain.Payment
import com.example.pcria.payment.command.domain.PaymentRepository
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class PaymentService(
    private val paymentRepository: PaymentRepository
) {
    @Transactional
    fun savePayment(payment: Payment) {
        paymentRepository.save(payment)
    }
}