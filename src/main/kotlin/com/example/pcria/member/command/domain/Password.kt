package com.example.pcria.member.command.domain

import jakarta.persistence.Column
import jakarta.persistence.Embeddable

@Embeddable
class Password(
    @Column(name = "password")
    private val value: String
) {
    fun match(password: String): Boolean = this.value == password
}