package com.example.pcria.payment.command.application

import com.example.pcria.common.model.Money
import com.example.pcria.order.command.domain.OrdererService
import com.example.pcria.payment.command.domain.Payment
import com.example.pcria.payment.command.domain.PaymentNo
import com.example.pcria.payment.command.domain.PaymentRepository
import com.example.pcria.payment.command.domain.PaymentState
import com.example.pcria.wallet.command.domain.Wallet
import com.example.pcria.wallet.command.domain.WalletNo
import com.example.pcria.wallet.command.domain.WalletRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class MoneyPaymentService(
    val paymentRepository: PaymentRepository,
    val walletRepository: WalletRepository,
    val ordererService: OrdererService
) {

    @Transactional
    fun moneyPayment(request: PaymentRequest): PaymentNo {
        val paymentNo = PaymentNo.nextPaymentNo()
        val orderer = ordererService.createOrderer(request.memberId)

        val payment = Payment(
            paymentNo,
            orderer,
            request.amount,
            PaymentState.COMPLETED,
            request.paymentMethod
        )

        val wallet = walletRepository.findByOrderer(orderer) ?: Wallet(
            WalletNo.of(orderer.memberId.id),
            orderer,
            Money.ZERO
        )

        wallet.addAmounts(request.amount)
        paymentRepository.save(payment)
        walletRepository.save(wallet)
        return paymentNo
    }
}