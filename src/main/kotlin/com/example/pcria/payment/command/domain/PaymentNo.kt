package com.example.pcria.payment.command.domain

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import java.io.Serializable

@Embeddable
class PaymentNo(
    @Column(name = "payment_number")
    private val number: Long
): Serializable {

    companion object {
        @JvmStatic
        fun of(number: Long): PaymentNo {
            return PaymentNo(number)
        }
    }

    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }

    override fun hashCode(): Int {
        return super.hashCode()
    }
}