package com.example.pcria.wallet.command.domain

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import java.io.Serializable

@Embeddable
class WalletNo(
    @Column(name = "wallet_number")
    private val number: Long
) : Serializable {

    companion object {
        @JvmStatic
        fun of(number: Long): WalletNo {
            return WalletNo(number)
        }
    }

    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }

    override fun hashCode(): Int {
        return super.hashCode()
    }
}