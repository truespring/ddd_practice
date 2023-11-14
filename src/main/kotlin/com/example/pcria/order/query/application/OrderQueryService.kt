package com.example.pcria.order.query.application

import com.example.pcria.order.NotFoundOrderException
import com.example.pcria.order.command.domain.Order
import com.example.pcria.order.command.domain.OrderNo
import com.example.pcria.order.command.domain.OrderRepository
import com.example.pcria.order.command.domain.Orderer
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class OrderQueryService(
    private val orderRepository: OrderRepository
) {
    @Transactional
    fun getOrderFromOrderNoAndMemberId(orderNo: OrderNo, orderer: Orderer): Order {
        return orderRepository.findByOrderNoAndOrderer(orderNo, orderer) ?: throw NotFoundOrderException()
    }

    @Transactional
    fun getOrderFromOrderNo(orderNo: OrderNo): Order {
        return orderRepository.findById(orderNo).orElseThrow { NotFoundOrderException() }
    }
}