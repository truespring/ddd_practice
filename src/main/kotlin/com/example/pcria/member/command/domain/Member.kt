package com.example.pcria.member.command.domain

import com.example.pcria.common.jpa.EmailSetConverter
import com.example.pcria.common.model.EmailSet
import jakarta.persistence.*

@Entity
@Table(name = "member")
class Member(
    @EmbeddedId
    private val id: MemberId,

    private val name: String,

    @Embedded
    private val password: Password,

    private val blocked: Boolean,

    @Convert(converter = EmailSetConverter::class)
    @Column(name = "emails")
    private val emails: EmailSet,

    @Column(name = "activated")
    private val activated: Boolean = false,
) {
    fun id(): MemberId = this.id
    fun name(): String = this.name
    fun password(): Password = this.password
}