package com.example.pcria.payment.command.domain

import com.example.pcria.order.command.domain.Orderer
import com.example.pcria.common.jpa.MoneyConverter
import com.example.pcria.common.model.Money
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "payment")
@Access(AccessType.FIELD)
class Payment(
    @EmbeddedId
    private val number: PaymentNo,

    @Embedded
    val orderer: Orderer,

    @Convert(converter = MoneyConverter::class)
    @Column(name = "amounts")
    private val amounts: Money,

    @Column(name = "state")
    @Enumerated(EnumType.STRING)
    private var state: PaymentState,

    @Column(name = "method")
    @Enumerated(EnumType.STRING)
    private val method: PaymentMethod,

    @Column(name = "date")
    private val date: LocalDateTime
) {

    constructor(
        number: PaymentNo,
        orderer: Orderer,
        amounts: Money,
        state: PaymentState,
        method: PaymentMethod
    ) : this(
        number,
        orderer,
        amounts,
        state,
        method,
        LocalDateTime.now()
    )

    fun cancel() {
        verifyAlreadyCanceled()
        this.state = PaymentState.CANCELED
    }

    private fun verifyAlreadyCanceled() {
        if (isAlreadyCanceled()) {
            throw IllegalStateException("이미 취소된 결제입니다.")
        }
    }

    private fun isAlreadyCanceled(): Boolean = this.state == PaymentState.CANCELED
}