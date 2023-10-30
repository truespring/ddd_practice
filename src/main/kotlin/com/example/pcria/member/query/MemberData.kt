package com.example.pcria.member.query

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "member")
class MemberData(
    @Id
    @Column(name = "member_id")
    val id: Long,

    @Column(name = "name")
    val name: String,

    @Column(name = "blocked")
    val blocked: Boolean
) {
}