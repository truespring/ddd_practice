package com.example.pcria.payment.command.application

import com.example.pcria.payment.command.domain.PaymentNo
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.jdbc.Sql

@SpringBootTest
@Sql("classpath:data-init-test.sql")
class CancelPaymentServiceTestIT(
    private val cancelPaymentService: CancelPaymentService
) {
    @Test
    fun cancel() {
    }
}