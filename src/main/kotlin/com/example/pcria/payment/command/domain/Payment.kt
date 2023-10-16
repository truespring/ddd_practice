package com.example.pcria.payment.command.domain

import com.example.pcria.payment.common.jpa.MoneyConverter
import com.example.pcria.payment.common.model.Money
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "payment")
@Access(AccessType.FIELD)
class Payment(
    @EmbeddedId
    val number: PaymentNo,

    @Embedded
    val orderer: Orderer,

    @Convert(converter = MoneyConverter::class)
    @Column(name = "amounts")
    private val amounts: Money,

    @Column(name = "state")
    @Enumerated(EnumType.STRING)
    val state: PaymentState,

    @Column(name = "method")
    @Enumerated(EnumType.STRING)
    val method: PaymentMethod,

    @Column(name = "date")
    val date: LocalDateTime
) {

}