package com.example.pcria.payment.command.domain

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import java.io.Serializable

@Embeddable
class PaymentNo(
    @Column(name = "payment_number")
    private val number: String
): Serializable {

    companion object {
        @JvmStatic
        fun of(number: String): PaymentNo {
            return PaymentNo(number)
        }
    }
}