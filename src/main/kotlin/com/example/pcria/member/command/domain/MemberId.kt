package com.example.pcria.member.command.domain

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import java.io.Serializable

@Embeddable
class MemberId(
    @Column(name = "member_id")
    private val id: Long
): Serializable {

    companion object {
        @JvmStatic
        fun of(id: Long): MemberId {
            return MemberId(id)
        }
    }
}