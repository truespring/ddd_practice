package com.example.pcria.order.command.domain

import com.example.pcria.common.jpa.MoneyConverter
import com.example.pcria.common.model.Money
import com.example.pcria.product.command.domain.ProductId
import jakarta.persistence.Column
import jakarta.persistence.Convert
import jakarta.persistence.Embeddable
import jakarta.persistence.Embedded

@Embeddable
class OrderLine(
    @Embedded
    private val productId: ProductId,

    @Convert(converter = MoneyConverter::class)
    @Column(name = "price")
    private val price: Money,

    @Column(name = "quantity")
    private val quantity: Int,

    @Convert(converter = MoneyConverter::class)
    @Column(name = "amounts")
    private val amounts: Money
) {
    fun productId() = this.productId
    fun price() = this.price
    fun quantity() = this.quantity
    fun amounts() = this.amounts
    fun calculateAmounts() = this.price.times(this.quantity)
}