package com.example.pcria.payment.ui

import com.example.pcria.member.command.domain.Member
import com.example.pcria.payment.command.application.CancelPaymentService
import com.example.pcria.payment.command.domain.Canceller
import com.example.pcria.payment.command.domain.PaymentNo
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@PaymentV1Controller
class CancelPaymentController(
    val cancelPaymentService: CancelPaymentService
) {
    @PostMapping("/{paymentNo}/cancel")
    fun cancelPayment(@PathVariable paymentNo: PaymentNo) {
        val user = SecurityContextHolder.getContext().authentication.principal as Member
        cancelPaymentService.cancelPayment(paymentNo, Canceller.of(user.id().id()));
    }
}