package com.example.pcria.order.command.domain

import com.example.pcria.common.jpa.MoneyConverter
import com.example.pcria.common.model.Money
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "purchase_order")
@Access(AccessType.FIELD)
class Order(
    @EmbeddedId
    private val orderNo: OrderNo,

    @Embedded
    private val orderer: Orderer,

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(
        name = "order_line",
        joinColumns = [JoinColumn(name = "order_number")]
    )
    @OrderColumn(name = "line_idx")
    private val orderLines: List<OrderLine>,

    @Convert(converter = MoneyConverter::class)
    @Column(name = "total_amounts")
    private val totalAmounts: Money,

    @Column(name = "state")
    @Enumerated(EnumType.STRING)
    private var state: OrderState,

    @Column(name = "order_date")
    private val orderDate: LocalDateTime
) {
    fun orderNo() = this.orderNo

    fun orderPrepare() {
        this.state = OrderState.PREPARING
    }

    fun cancelOrder() {
        verifyPreparing()
        verifyAlreadyCanceled()
        this.state = OrderState.CANCELLED
    }

    private fun verifyAlreadyCanceled() {
        when {
            isAlreadyCanceled() -> throw IllegalStateException("이미 취소된 주문입니다.")
        }
    }

    private fun verifyPreparing() {
        when {
            isPreparing() -> throw IllegalStateException("이미 준비중인 주문입니다.")
        }
    }
    private fun isAlreadyCanceled() = this.state == OrderState.CANCELLED
    private fun isPreparing() = this.state == OrderState.PREPARING
}