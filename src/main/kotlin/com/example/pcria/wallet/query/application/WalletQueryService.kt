package com.example.pcria.wallet.query.application

import com.example.pcria.member.command.domain.MemberId
import com.example.pcria.wallet.NotFoundWalletException
import com.example.pcria.wallet.command.domain.Wallet
import com.example.pcria.wallet.command.domain.WalletRepository
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class WalletQueryService(
    private val walletRepository: WalletRepository
) {
    @Transactional
    fun getWalletFromMemberId(memberId: MemberId): Wallet {
        return walletRepository.findByMemberId(memberId) ?: throw NotFoundWalletException()
    }
}