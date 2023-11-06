package com.example.pcria.payment.command.application

import com.example.pcria.payment.command.domain.*
import com.example.pcria.payment.query.application.PaymentQueryService
import com.example.pcria.wallet.query.application.WalletQueryService
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class CancelPaymentService(
    private val paymentQueryService: PaymentQueryService,
    private val walletQueryService: WalletQueryService,
    private val cancelPolicy: CancelPolicy
) {
    @Transactional
    fun cancelPayment(paymentNo: PaymentNo, canceller: Canceller) {
        val payment = paymentQueryService.getPaymentFromPaymentNo(paymentNo)
        if (!cancelPolicy.hasCancellationPermission(payment, canceller)) {
            throw NoCancellablePermission()
        }
        walletQueryService.getWalletFromMemberId(payment.orderer().memberId())
            .minusAmount(payment.amount())
        payment.cancel()
    }
}