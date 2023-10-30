package com.example.pcria.wallet.command.domain

import com.example.pcria.order.command.domain.Orderer
import com.example.pcria.common.jpa.MoneyConverter
import com.example.pcria.common.model.Money
import jakarta.persistence.*

@Entity
@Table(name = "wallet")
@Access(AccessType.FIELD)
class Wallet(
    @EmbeddedId
    private val number: WalletNo,

    @Embedded
    private val orderer: Orderer,

    @Convert(converter = MoneyConverter::class)
    @Column(name = "total_amounts")
    private val totalAmounts: Money
) {
    fun totalAmounts(): Money = this.totalAmounts

    fun addAmount(amount: Money) {
        this.totalAmounts.plus(amount)
    }

    fun minusAmount(amount: Money) {
        this.totalAmounts.minus(amount)
    }
}
