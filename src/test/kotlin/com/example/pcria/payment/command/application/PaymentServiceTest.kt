package com.example.pcria.payment.command.application

import com.example.pcria.payment.command.domain.PaymentRepository
import com.example.pcria.wallet.command.domain.WalletRepository
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock

class PaymentServiceTest {

    @Test
    @DisplayName("회원이 아니면 예외가 발생한다.")
    fun noMember_thenExceptionShouldBeThrown() {
        val stubPaymentRepo = mock(PaymentRepository::class.java)
        val stubWalletRepo = mock(WalletRepository::class.java)

    }
}
