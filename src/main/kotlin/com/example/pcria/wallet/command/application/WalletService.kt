package com.example.pcria.wallet.command.application

import com.example.pcria.wallet.command.domain.Wallet
import com.example.pcria.wallet.command.domain.WalletRepository
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class WalletService(
    private val walletRepository: WalletRepository
) {
    @Transactional
    fun saveWallet(wallet: Wallet): Wallet {
        return walletRepository.save(wallet)
    }
}