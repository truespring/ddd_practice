package com.example.pcria.catalog.command.domain.product

import jakarta.persistence.Access
import jakarta.persistence.AccessType
import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import java.io.Serializable

@Embeddable
@Access(AccessType.FIELD)
data class ProductId(
    @Column(name = "product_id")
    private val id: Long,
): Serializable {
    fun id() = this.id

    companion object {
        @JvmStatic
        fun of(id: Long): ProductId {
            return ProductId(id)
        }
    }
}