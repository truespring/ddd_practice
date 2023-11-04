package com.example.pcria.member.query

import com.example.pcria.member.command.application.NoMemberException
import org.springframework.stereotype.Service

@Service
class MemberQueryService(
    val memberDataDao: MemberDataDao,
) {
    fun getMemberData(id: Long): MemberData = memberDataDao.findById(id).orElseThrow { NoMemberException() }
}