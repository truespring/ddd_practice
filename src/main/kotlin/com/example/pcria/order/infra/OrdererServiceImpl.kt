package com.example.pcria.order.infra

import com.example.pcria.member.command.domain.MemberId
import com.example.pcria.member.query.MemberQueryService
import com.example.pcria.order.command.domain.Orderer
import com.example.pcria.order.command.domain.OrdererService
import org.springframework.stereotype.Service

@Service
class OrdererServiceImpl(
    private val memberQueryService: MemberQueryService
): OrdererService {

    override fun createOrderer(ordererMemberId: MemberId): Orderer {
        val memberData = memberQueryService.getMemberData(ordererMemberId.id)
        return Orderer(MemberId.of(memberData!!.id), memberData.name)
    }
}