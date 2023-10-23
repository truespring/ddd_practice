package com.example.pcria.payment.command.application

import com.example.pcria.common.model.Money
import com.example.pcria.member.command.domain.MemberId
import com.example.pcria.payment.command.domain.PaymentMethod

class PaymentRequest(
    val memberId: MemberId,
    val amount: Money,
    val paymentMethod: PaymentMethod
) {
}