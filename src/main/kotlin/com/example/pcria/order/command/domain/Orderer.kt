package com.example.pcria.order.command.domain

import com.example.pcria.member.command.domain.MemberId
import jakarta.persistence.AttributeOverride
import jakarta.persistence.AttributeOverrides
import jakarta.persistence.Column
import jakarta.persistence.Embeddable

@Embeddable
class Orderer(
    @AttributeOverrides(
        AttributeOverride(name = "id", column = Column(name = "orderer_id"))
    )
    private val memberId: MemberId,
) {
    fun memberId(): MemberId = this.memberId
}