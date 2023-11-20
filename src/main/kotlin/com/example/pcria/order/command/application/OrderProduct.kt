package com.example.pcria.order.command.application

class OrderProduct(
    private val productId: Long,
    private val quantity: Int
) {
    fun productId(): Long = this.productId
    fun quantity(): Int = this.quantity
}