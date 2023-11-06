package com.example.pcria.wallet.command.domain

import com.example.pcria.member.command.domain.MemberId
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface WalletRepository : JpaRepository<Wallet, WalletNo> {
    fun findByMemberId(memberId: MemberId): Wallet?
    fun save(wallet: Wallet): Wallet
}