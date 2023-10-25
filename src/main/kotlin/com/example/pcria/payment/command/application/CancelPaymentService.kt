package com.example.pcria.payment.command.application

import com.example.pcria.payment.command.NoPaymentException
import com.example.pcria.payment.command.domain.*
import com.example.pcria.wallet.NoWalletException
import com.example.pcria.wallet.command.domain.WalletRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class CancelPaymentService(
    private val paymentRepository: PaymentRepository,
    private val walletRepository: WalletRepository,
    private val cancelPolicy: CancelPolicy
) {
    @Transactional
    fun cancelPayment(paymentNo: PaymentNo, canceller: Canceller) {
        val payment = paymentRepository.findById(paymentNo)
            .orElseThrow { NoPaymentException() }
        if (!cancelPolicy.hasCancellationPermission(payment, canceller)) {
            throw NoCancellablePermission()
        }
        val wallet = walletRepository.findByOrderer(payment.orderer)
            .let { it ?: throw NoWalletException() }
        wallet.minusAmounts(payment.amounts)
        payment.cancel()
    }
}