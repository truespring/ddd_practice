package com.example.pcria.order.command.application

import com.example.pcria.order.command.domain.Order
import com.example.pcria.order.command.domain.OrderNo
import com.example.pcria.order.command.domain.OrdererService
import com.example.pcria.order.query.application.OrderQueryService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class OrderService(
    private val orderQueryService: OrderQueryService,
    private val ordererService: OrdererService
) {
//    @Transactional
//    fun placeOrder(request: OrderRequest): OrderNo {
//        val orderNo = OrderNo.nextOrderNo()
//        val orderer = ordererService.createOrderer(request.memberId())
//    }

    @Transactional
    fun orderPrepare(orderNo: OrderNo): OrderNo {
        val order = orderQueryService.getOrderFromOrderNo(orderNo)
        order.prepare()
        return order.orderNo()
    }
}