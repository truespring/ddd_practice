package com.example.pcria.order.command.domain

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import java.io.Serializable

@Embeddable
data class OrderNo(
    @Column(name = "order_number")
    private val id: Long
) : Serializable {
    fun id(): Long = this.id
}
