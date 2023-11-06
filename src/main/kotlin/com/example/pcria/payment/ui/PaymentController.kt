package com.example.pcria.payment.ui

import com.example.pcria.member.command.domain.Member
import com.example.pcria.payment.command.application.PaymentFacade
import com.example.pcria.payment.command.application.PaymentRequest
import com.example.pcria.payment.command.domain.Canceller
import com.example.pcria.payment.command.domain.PaymentNo
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@PaymentV1Controller
class PaymentController(
    val paymentFacade: PaymentFacade
) {
    @PostMapping("/payment")
    fun payment(@RequestBody paymentRequest: PaymentRequest): PaymentNo =
        paymentFacade.payment(paymentRequest)

    @PostMapping("/{paymentNo}/cancel")
    fun cancelPayment(@PathVariable paymentNo: Long) {
        val user = SecurityContextHolder.getContext().authentication.principal as Member
        paymentFacade.cancelPayment(PaymentNo.of(paymentNo), Canceller.of(user.memberId()));
    }
}