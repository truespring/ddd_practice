package com.example.pcria.wallet.command.domain

import com.example.pcria.payment.command.domain.Orderer
import com.example.pcria.payment.common.jpa.MoneyConverter
import com.example.pcria.payment.common.model.Money
import jakarta.persistence.*

@Entity
@Table(name = "wallet")
@Access(AccessType.FIELD)
class Wallet(
    @EmbeddedId
    val number: WalletNo,

    @Embedded
    val orderer: Orderer,

    @Convert(converter = MoneyConverter::class)
    @Column(name = "total_amounts")
    private val amounts: Money
) {

    fun addAmounts(amounts: Money) {
        this.amounts.plus(amounts)
    }

}
