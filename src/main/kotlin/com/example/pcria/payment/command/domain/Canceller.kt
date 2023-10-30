package com.example.pcria.payment.command.domain

class Canceller(
    val memberId: Long
) {
    companion object {
        @JvmStatic
        fun of(memberId: Long): Canceller = Canceller(memberId)
    }
}