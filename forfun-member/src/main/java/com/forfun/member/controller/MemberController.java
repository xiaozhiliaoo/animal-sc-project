package com.forfun.member.controller;

import com.forfun.member.service.MemberService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class MemberController {


    @Autowired
    private MemberService memberService;

    @RequestMapping(value = "/members/member/{id}")
    public String findMemberById(@PathVariable("id") String id) {
        try {
            return memberService.changeMemberPoint(id).getId();
        } catch (Exception e) {
            return null;
        }
    }

}
