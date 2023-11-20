package com.example.pcria.catalog.command.domain.category

import jakarta.persistence.Access
import jakarta.persistence.AccessType
import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import java.io.Serializable

@Embeddable
@Access(AccessType.FIELD)
data class CategoryId(
    @Column(name = "category_id")
    private val value: Long
): Serializable {
    fun value() = this.value

    companion object {
        @JvmStatic
        fun of(value: Long): CategoryId {
            return CategoryId(value)
        }
    }
}