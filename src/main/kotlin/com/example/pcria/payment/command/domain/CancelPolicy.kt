package com.example.pcria.payment.command.domain

fun interface CancelPolicy {
    fun hasCancellationPermission(payment: Payment, canceller: Canceller): Boolean
}