package com.example.pcria.payment.infra.domain

import com.example.pcria.payment.command.domain.CancelPolicy
import com.example.pcria.payment.command.domain.Canceller
import com.example.pcria.payment.command.domain.Payment
import org.springframework.security.core.Authentication
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.context.SecurityContext
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component

@Component
class SecurityCancelPolicy : CancelPolicy {
    override fun hasCancellationPermission(payment: Payment, canceller: Canceller): Boolean =
        isCurrentUserAdminRole() || isCancellerPayment(payment, canceller)

    private fun isCancellerPayment(payment: Payment, canceller: Canceller): Boolean =
        payment.memberId().id() == canceller.memberId

    private fun isCurrentUserAdminRole(): Boolean {
        val context: SecurityContext = SecurityContextHolder.getContext() ?: return false
        val authentication: Authentication = context.authentication ?: return false
        val authorities: Collection<GrantedAuthority> = authentication.authorities ?: return false
        return authorities.stream().anyMatch { authority: GrantedAuthority ->
            authority.authority == "ROLE_ADMIN"
        }
    }
}