package com.example.pcria.payment.command.application

import com.example.pcria.payment.command.NoPaymentException
import com.example.pcria.payment.command.domain.PaymentNo
import com.example.pcria.payment.command.domain.PaymentRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class CancelPaymentService(
    private val paymentRepository: PaymentRepository
) {
    @Transactional
    fun cancelPayment(paymentNo: PaymentNo) {
        paymentRepository.findByNumber(paymentNo)
            .let { it ?: throw NoPaymentException() }
            .cancel()
    }
}