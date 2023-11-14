package com.example.pcria.order.command.application

import com.example.pcria.member.command.domain.MemberId
import com.example.pcria.order.command.domain.OrderNo

class OrderRequest(
    private val ordererMemberId: MemberId,
    private val orderId: OrderNo
) {
    fun memberId(): MemberId = this.ordererMemberId
    fun orderId(): OrderNo = this.orderId
}