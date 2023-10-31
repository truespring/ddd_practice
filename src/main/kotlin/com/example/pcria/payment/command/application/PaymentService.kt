package com.example.pcria.payment.command.application

import com.example.pcria.order.command.domain.OrdererService
import com.example.pcria.payment.command.domain.*
import com.example.pcria.payment.query.MoneyPaymentDto
import com.example.pcria.wallet.NoWalletException
import com.example.pcria.wallet.command.domain.WalletRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class PaymentService(
    val paymentRepository: PaymentRepository,
    val walletRepository: WalletRepository,
    val ordererService: OrdererService,
    val moneyPaymentService: MoneyPaymentService
) {

    @Transactional
    fun moneyPayment(request: PaymentRequest): PaymentNo {
        val paymentNo = PaymentNo.nextPaymentNo()
        val wallet = walletRepository.findByMemberId(request.memberId)
            ?: throw NoWalletException()

        moneyPaymentService.payment(MoneyPaymentDto.of(request.amount))
        wallet.addAmount(request.amount)
        walletRepository.save(wallet)

        paymentRepository.save(Payment(
            paymentNo,
            ordererService.createOrderer(request.memberId),
            request.amount,
            PaymentState.COMPLETED,
            request.paymentMethod
        ))
        return paymentNo
    }
}