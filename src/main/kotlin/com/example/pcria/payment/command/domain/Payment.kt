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
    val number: PaymentNo,

    @Embedded
    val orderer: Orderer,

    @Convert(converter = MoneyConverter::class)
    @Column(name = "amounts")
    private val amounts: Money,

    @Column(name = "state")
    @Enumerated(EnumType.STRING)
    var state: PaymentState,

    @Column(name = "method")
    @Enumerated(EnumType.STRING)
    val method: PaymentMethod,

    @Column(name = "date")
    val date: LocalDateTime
) {

    fun changePaymentState() {
        verifyAlreadyCanceled()
    }

    fun cancel() {
        verifyAlreadyCanceled()
        this.state = PaymentState.CANCELED
    }

    private fun verifyAlreadyCanceled() {
        if (isAlreadyCanceled()) {
            throw IllegalStateException("이미 취소된 결제입니다.")
        }
    }

    private fun isAlreadyCanceled(): Boolean {
        return this.state == PaymentState.CANCELED
    }
}