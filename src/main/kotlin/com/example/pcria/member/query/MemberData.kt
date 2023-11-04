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
    private val id: Long,

    @Column(name = "name")
    private val name: String,

    @Column(name = "blocked")
    private val blocked: Boolean
) {
    fun id(): Long = this.id
    fun name(): String = this.name
    fun blocked(): Boolean = this.blocked
}