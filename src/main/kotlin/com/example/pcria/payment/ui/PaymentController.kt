package com.example.pcria.payment.ui

import com.example.pcria.payment.command.application.MoneyPaymentService
import com.example.pcria.payment.command.application.PaymentRequest
import com.example.pcria.payment.command.domain.PaymentNo
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController("/api/v1/payments")
class PaymentController(
    val moneyPaymentService: MoneyPaymentService
) {

    @PostMapping("/payment")
    fun payment(@RequestBody paymentRequest: PaymentRequest): PaymentNo =
        moneyPaymentService.moneyPayment(paymentRequest)
}