package com.example.pcria.member.query

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface MemberDataDao : JpaRepository<MemberData, Long> {
    override fun findById(id: Long): Optional<MemberData>
}