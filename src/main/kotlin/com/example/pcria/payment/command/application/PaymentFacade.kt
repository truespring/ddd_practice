package com.example.pcria.payment.command.application

import com.example.pcria.order.command.domain.OrdererService
import com.example.pcria.payment.command.domain.*
import com.example.pcria.payment.query.application.PaymentQueryService
import com.example.pcria.payment.query.dto.MoneyPaymentDto
import com.example.pcria.wallet.command.application.WalletService
import com.example.pcria.wallet.query.application.WalletQueryService
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class PaymentFacade(
    private val moneyPaymentService: MoneyPaymentService,
    private val paymentQueryService: PaymentQueryService,
    private val walletQueryService: WalletQueryService,
    private val paymentService: PaymentService,
    private val ordererService: OrdererService,
    private val walletService: WalletService,
    private val cancelPolicy: CancelPolicy
) {
    @Transactional
    fun payment(request: PaymentRequest): PaymentNo {
        val paymentNo = PaymentNo.nextPaymentNo()
        val wallet = walletQueryService.getWalletFromMemberId(request.memberId())

        moneyPaymentService.payment(MoneyPaymentDto.of(request.amount()))
        wallet.addAmount(request.amount())
        walletService.saveWallet(wallet)
        paymentService.savePayment(
            Payment(
                paymentNo,
                ordererService.createOrderer(request.memberId()),
                request.amount(),
                PaymentState.COMPLETED,
                request.paymentMethod()
            )
        )
        return paymentNo
    }

    @Transactional
    fun cancelPayment(paymentNo: PaymentNo, canceller: Canceller) {
        val payment = paymentQueryService.getPaymentFromPaymentNo(paymentNo)
        if (!cancelPolicy.hasCancellationPermission(payment, canceller)) {
            throw NoCancellablePermission()
        }
        payment.cancel()
        walletQueryService.getWalletFromMemberId(payment.orderer().memberId())
            .minusAmount(payment.amount())
    }
}