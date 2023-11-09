package com.example.pcria.product.command.domain

import jakarta.persistence.Access
import jakarta.persistence.AccessType
import jakarta.persistence.Column
import jakarta.persistence.Embeddable

@Embeddable
@Access(AccessType.FIELD)
data class ProductId(
    @Column(name = "product_id")
    private val id: String,
) {
    fun id() = this.id

    companion object {
        @JvmStatic
        fun of(id: String): ProductId {
            return ProductId(id)
        }
    }
}