package com.forfun.member.service.impl;


import com.forfun.member.domain.entity.Member;
import com.forfun.member.feign.client.MarketingClient;
import com.forfun.member.response.DefaultResponse;
import com.forfun.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MarketingClient marketingClient;

    @Override
    public Member changeMemberPoint(String memberId) throws Exception {
        //search from db
        //Member member = memberService.findById(memberId);
        Member member = new Member();
        if (null != member) {
            if (null != member.getId()) {
                String userId = member.getId();
                //rpc
                DefaultResponse<String> id = marketingClient.findByUserId(userId);
                if (id.getData()!=null) {
                    return member;
                }
            }
        }
        return null;
    }
}
