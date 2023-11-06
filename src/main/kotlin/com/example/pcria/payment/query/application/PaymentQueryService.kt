package com.example.pcria.payment.query.application

import com.example.pcria.payment.command.NoPaymentException
import com.example.pcria.payment.command.domain.Payment
import com.example.pcria.payment.command.domain.PaymentNo
import com.example.pcria.payment.command.domain.PaymentRepository
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional

@Component
class PaymentQueryService(
    private val paymentRepository: PaymentRepository
) {
    @Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
    fun getPaymentFromPaymentNo(paymentNo: PaymentNo): Payment {
        return paymentRepository.findById(paymentNo).orElseThrow { NoPaymentException() }
    }
}