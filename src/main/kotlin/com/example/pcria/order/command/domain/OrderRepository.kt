package com.example.pcria.order.command.domain

import org.springframework.data.jpa.repository.JpaRepository

interface OrderRepository: JpaRepository<Order, OrderNo> {
    fun findByOrderNoAndOrderer(orderNo: OrderNo, orderer: Orderer): Order?
}