package com.example.pcria.payment.command.domain

import com.example.pcria.member.command.domain.MemberId
import com.example.pcria.order.command.domain.Orderer
import com.example.pcria.common.model.Money
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import java.time.LocalDateTime

@DataJpaTest
class PaymentRepositoryIT{

    @Autowired
    private val paymentRepository: PaymentRepository? = null

    @Test
    fun save() {
        val payment = Payment(
            PaymentNo.of(1),
            Orderer(
                MemberId.of(2),
                "name"
            ),
            Money(1000),
            PaymentState.COMPLETED,
            PaymentMethod.CARD,
            LocalDateTime.now()
        )
        paymentRepository?.save(payment)
    }
}