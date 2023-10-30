package com.example.pcria.wallet.command.domain

import com.example.pcria.order.command.domain.Orderer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface WalletRepository : JpaRepository<Wallet, WalletNo> {
    fun findByOrderer(orderer: Orderer): Wallet
}