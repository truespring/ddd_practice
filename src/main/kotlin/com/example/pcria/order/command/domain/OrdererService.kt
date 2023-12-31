package com.example.pcria.order.command.domain

import com.example.pcria.member.command.domain.MemberId

fun interface OrdererService {
    fun createOrderer(ordererMemberId: MemberId): Orderer
}