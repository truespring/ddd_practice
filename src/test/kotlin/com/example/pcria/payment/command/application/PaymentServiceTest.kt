package com.example.pcria.payment.command.application

import com.example.pcria.common.model.Money
import com.example.pcria.member.command.domain.MemberId
import com.example.pcria.order.command.domain.OrdererService
import com.example.pcria.payment.command.domain.MoneyPaymentService
import com.example.pcria.payment.command.domain.PaymentMethod
import com.example.pcria.payment.command.domain.PaymentRepository
import com.example.pcria.wallet.NoWalletException
import com.example.pcria.wallet.command.domain.Wallet
import com.example.pcria.wallet.command.domain.WalletNo
import com.example.pcria.wallet.command.domain.WalletRepository
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.Mockito.mock

class PaymentServiceTest {

    @Test
    @DisplayName("회원이 아니면 예외가 발생한다.")
    fun noMember_thenExceptionShouldBeThrown() {
        TODO("개선 필요")
        val stubPaymentRepo = mock(PaymentRepository::class.java)
        val stubWalletRepo = mock(WalletRepository::class.java)
        val ordererService = mock(OrdererService::class.java)
        val moneyPaymentService = mock(MoneyPaymentService::class.java)

        Mockito.`when`(stubWalletRepo.findByMemberId(MemberId.of(4)))
            .thenReturn(null)

        Mockito.`when`(stubWalletRepo.findByMemberId(MemberId.of(3)))
            .thenReturn(
                Wallet(
                    WalletNo.of(1),
                    MemberId.of(3),
                    Money.wons(1000)
                )
            )

        val paymentService = PaymentService(
            stubPaymentRepo,
            stubWalletRepo,
            ordererService,
            moneyPaymentService
        )

        assertThrows(NoWalletException::class.java) {
            paymentService.moneyPayment(
                PaymentRequest(
                    MemberId.of(3),
                    Money.wons(1000),
                    PaymentMethod.CARD
                )
            )
        }
    }
}
