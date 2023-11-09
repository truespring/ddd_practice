package com.example.pcria.payment.command.application

import com.example.pcria.common.model.Money
import com.example.pcria.member.command.domain.MemberId
import com.example.pcria.payment.command.domain.Canceller
import com.example.pcria.payment.command.domain.PaymentMethod
import com.example.pcria.payment.command.domain.PaymentNo
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.jdbc.Sql

@SpringBootTest
@Sql("classpath:data-init-test.sql")
class PaymentFacadeTest {

    @Autowired
    private lateinit var paymentFacade: PaymentFacade


    @Test
    @DisplayName("Card Payment Should Succeed")
    fun cardPaymentShouldSucceed() {
        paymentFacade.payment(
            PaymentRequest(
                MemberId.of(1),
                Money.wons(1000),
                PaymentMethod.CARD
            )
        )
    }

    @Test
    @DisplayName("Cash Payment Should Succeed")
    fun cashPaymentShouldSucceed() {
        paymentFacade.payment(
            PaymentRequest(
                MemberId.of(1),
                Money.wons(1000),
                PaymentMethod.CASH
            )
        )
    }

    @Test
    @DisplayName("Already Canceled Payment")
    fun alreadyCanceledPayment() {
        assertThrows<IllegalStateException> {
            paymentFacade.cancelPayment(
                PaymentNo.of(3),
                Canceller.of(1)
            )
        }
    }

    @Test
    @DisplayName("Cancelable Payment")
    fun cancelablePayment() {
        paymentFacade.cancelPayment(
            PaymentNo.of(1),
            Canceller.of(1)
        )
    }

    @Test
    @DisplayName("Non-Cancelable Payment")
    fun nonCancelablePayment() {
        assertThrows<IllegalArgumentException> {
            paymentFacade.cancelPayment(
                PaymentNo.of(2),
                Canceller.of(2)
            )
        }
    }
}
