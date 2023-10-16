package com.example.pcria.payment.command.domain

import com.example.pcria.order.command.domain.Orderer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PaymentRepository : JpaRepository<Payment, PaymentNo> {
    fun findByOrderer(orderer: Orderer): Payment?
}