package com.example.pcria.member.command.domain

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import java.io.Serializable

@Embeddable
class MemberId(
    @Column(name = "member_id")
    private val id: String
): Serializable {

    companion object {
        @JvmStatic
        fun of(id: String): MemberId {
            return MemberId(id)
        }
    }
}