package com.example.pcria.wallet.command.domain

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import java.io.Serializable
import java.util.*
import java.util.concurrent.ThreadLocalRandom

@Embeddable
data class WalletNo(
    @Column(name = "wallet_number")
    private val number: Long
) : Serializable {
    fun number(): Long = this.number

    companion object {
        @JvmStatic
        fun of(number: Long): WalletNo {
            return WalletNo(number)
        }

        @JvmStatic
        fun nextWalletNo(): WalletNo {
            return WalletNo(
                String.format(
                    "%tY%<tm%<td%<tH%d",
                    Date(),
                    ThreadLocalRandom.current().nextInt(800000) + 100000
                ).toLong()
            )
        }
    }

    override fun equals(other: Any?): Boolean {
        if (other?.javaClass != this.javaClass) return false
        return super.equals(other)
    }

    override fun hashCode(): Int {
        return super.hashCode()
    }
}