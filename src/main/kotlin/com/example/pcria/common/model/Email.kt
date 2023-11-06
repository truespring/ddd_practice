package com.example.pcria.common.model

data class Email(
    private val address: String
) {
    companion object {
        @JvmStatic
        fun of(address: String): Email = Email(address)
    }
    fun address(): String = this.address
}