package com.example.pcria.order.command.application

import com.example.pcria.member.command.domain.MemberId
import com.example.pcria.order.command.domain.OrderNo

class OrderRequest(
    private val ordererMemberId: MemberId,
    private val orderProducts: List<OrderProduct>
) {
    fun memberId(): MemberId = this.ordererMemberId
    fun orderProducts(): List<OrderProduct> = this.orderProducts
}