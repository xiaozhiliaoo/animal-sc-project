package com.forfun.member.service;


import com.forfun.member.domain.entity.Member;

public interface MemberService {

    Member changeMemberPoint(String memberId) throws Exception;

}
