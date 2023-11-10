package com.example.pcria.payment.command.domain

import com.example.pcria.common.jpa.MoneyConverter
import com.example.pcria.common.model.Money
import com.example.pcria.member.command.domain.MemberId
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "payment")
@Access(AccessType.FIELD)
class Payment(
    @EmbeddedId
    private val number: PaymentNo,

    @Embedded
    private val memberId: MemberId,

    @Convert(converter = MoneyConverter::class)
    @Column(name = "amount")
    private val amount: Money,

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
        memberId: MemberId,
        amount: Money,
        state: PaymentState,
        method: PaymentMethod
    ) : this(
        number,
        memberId,
        amount,
        state,
        method,
        LocalDateTime.now()
    )

    fun amount() = this.amount
    fun memberId() = this.memberId

    fun cancelPayment() {
        verifyAlreadyCanceled()
        this.state = PaymentState.CANCELED
    }

    private fun verifyAlreadyCanceled() {
        when {
            isAlreadyCanceled() -> throw IllegalStateException("이미 취소된 결제입니다.")
        }
    }

    private fun isAlreadyCanceled(): Boolean = this.state == PaymentState.CANCELED
}