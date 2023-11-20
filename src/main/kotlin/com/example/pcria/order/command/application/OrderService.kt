package com.example.pcria.order.command.application

import com.example.pcria.catalog.command.domain.product.Product
import com.example.pcria.catalog.command.domain.product.ProductId
import com.example.pcria.catalog.command.domain.product.ProductRepository
import com.example.pcria.order.command.domain.OrderLine
import com.example.pcria.order.command.domain.OrderNo
import com.example.pcria.order.command.domain.OrderRepository
import com.example.pcria.order.command.domain.OrdererService
import com.example.pcria.order.query.application.OrderQueryService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*
import java.util.function.Supplier

@Service
class OrderService(
    private val orderQueryService: OrderQueryService,
    private val orderRepository: OrderRepository,
    private val ordererService: OrdererService,
    private val productRepository: ProductRepository
) {
    @Transactional
    fun placeOrder(request: OrderRequest): OrderNo {
        val orderLines: MutableList<OrderLine> = ArrayList()
        for (op in request.orderProducts()) {
            val product: Product = productRepository.findById(ProductId(op.productId()))
                .orElseThrow {
                    NoOrderProductException(
                        op.productId()
                    )
                }
            orderLines.add(OrderLine(product.id(), product.price(), op.quantity()))
        }
        val orderNo = OrderNo.nextOrderNo()
        val orderer = ordererService.createOrderer(request.memberId())
        return orderNo
    }

    @Transactional
    fun orderPrepare(orderNo: OrderNo): OrderNo {
        val order = orderQueryService.getOrderFromOrderNo(orderNo)
        order.prepare()
        return order.orderNo()
    }
}