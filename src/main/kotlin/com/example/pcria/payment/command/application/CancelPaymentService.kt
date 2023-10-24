package com.example.pcria.payment.command.application

import com.example.pcria.payment.command.NoPaymentException
import com.example.pcria.payment.command.domain.*
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class CancelPaymentService(
    private val paymentRepository: PaymentRepository,
    private val cancelPolicy: CancelPolicy
) {
    @Transactional
    fun cancelPayment(paymentNo: PaymentNo, canceller: Canceller) {
        val payment = paymentRepository.findById(paymentNo)
            .orElseThrow { NoPaymentException() }
        if (!cancelPolicy.hasCancellationPermission(payment, canceller)) {
            throw NoCancellablePermission()
        }
        payment.cancel()
    }
}