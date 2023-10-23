package com.example.pcria.payment.command.domain

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import java.io.Serializable
import java.util.*
import java.util.concurrent.ThreadLocalRandom

@Embeddable
data class PaymentNo(
    @Column(name = "payment_number")
    val number: Long
) : Serializable {

    companion object {
        @JvmStatic
        fun of(number: Long): PaymentNo {
            return PaymentNo(number)
        }

        @JvmStatic
        fun nextPaymentNo(): PaymentNo {
            return PaymentNo(
                String.format(
                    "%tY%<tm%<td%<tH-%d",
                    Date(),
                    ThreadLocalRandom.current().nextInt(900000) + 100000
                ).toLong()
            )
        }
    }

    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }

    override fun hashCode(): Int {
        return super.hashCode()
    }
}