package com.example.pcria.payment.ui

import com.example.pcria.payment.command.application.PaymentService
import com.example.pcria.payment.command.application.PaymentRequest
import com.example.pcria.payment.command.domain.PaymentNo
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@PaymentV1Controller
class PaymentController(
    val paymentService: PaymentService
) {
    @PostMapping("/payment")
    fun payment(@RequestBody paymentRequest: PaymentRequest): PaymentNo =
        paymentService.moneyPayment(paymentRequest)
}