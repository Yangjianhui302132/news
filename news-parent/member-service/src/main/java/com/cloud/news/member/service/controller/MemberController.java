package com.cloud.news.member.service.controller;

import com.cloud.news.member.service.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

    @Autowired
    private MemberService memberService;

    @RequestMapping("/hi")
    public String hi(@RequestParam(value = "name", defaultValue = "jeff") String name) {
        return memberService.sayHi(name);
    }
}
