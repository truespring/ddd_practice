package com.example.pcria.wallet.query.application

import com.example.pcria.member.command.domain.MemberId
import com.example.pcria.wallet.NoWalletException
import com.example.pcria.wallet.command.domain.Wallet
import com.example.pcria.wallet.command.domain.WalletNo
import com.example.pcria.wallet.command.domain.WalletRepository
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional

@Component
class WalletQueryService(
    private val walletRepository: WalletRepository
) {

    @Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
    fun getWalletFromWalletNo(walletNo: WalletNo): Wallet {
        return walletRepository.findById(walletNo).orElseThrow { NoWalletException() }
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
    fun getWalletFromMemberId(memberId: MemberId): Wallet {
        return walletRepository.findByMemberId(memberId) ?: throw NoWalletException()
    }
}