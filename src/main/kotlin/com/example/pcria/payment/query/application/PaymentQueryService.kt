package com.example.pcria.payment.query.application

import com.example.pcria.payment.command.NotFoundPaymentException
import com.example.pcria.payment.command.domain.Payment
import com.example.pcria.payment.command.domain.PaymentNo
import com.example.pcria.payment.command.domain.PaymentRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PaymentQueryService(
    private val paymentRepository: PaymentRepository
) {
    @Transactional
    fun getPaymentFromPaymentNo(paymentNo: PaymentNo): Payment {
        return paymentRepository.findById(paymentNo).orElseThrow { NotFoundPaymentException() }
    }
}