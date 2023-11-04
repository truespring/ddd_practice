package com.example.pcria.payment.command.application

import com.example.pcria.common.model.Money
import com.example.pcria.member.command.domain.MemberId
import com.example.pcria.payment.command.domain.PaymentMethod
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.jdbc.Sql

@SpringBootTest
@Sql("classpath:data-init-test.sql")

class PaymentServiceTest {

    @Autowired
    private lateinit var paymentService: PaymentService

    @Test
    fun moneyPayment() {
        paymentService.moneyPayment(
            PaymentRequest(
                MemberId.of(2),
                Money.wons(1000),
                PaymentMethod.CARD
            )
        )
    }
}
