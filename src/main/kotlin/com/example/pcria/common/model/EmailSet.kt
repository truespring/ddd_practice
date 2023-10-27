package com.example.pcria.common.model

class EmailSet(
    private val emails: Set<Email>
) {
    fun emails(): Set<Email> = this.emails
}