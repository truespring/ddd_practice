package com.example.pcria.order.command.application

class NoOrderProductException(
    private val productId: Long
): RuntimeException() {

    fun productId() = this.productId
}