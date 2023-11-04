package com.example.pcria.member.query

import org.springframework.data.jpa.repository.JpaRepository

interface MemberDataDao : JpaRepository<MemberData, Long> {
}