package com.example.pcria.payment.command.application

import com.example.pcria.common.model.Money
import com.example.pcria.member.command.domain.MemberId
import com.example.pcria.payment.command.domain.PaymentMethod

class PaymentRequest(
    private val memberId: MemberId,
    private val amount: Money,
    private val paymentMethod: PaymentMethod
) {
    fun memberId(): MemberId = this.memberId
    fun amount(): Money = this.amount
    fun paymentMethod(): PaymentMethod = this.paymentMethod
}