package com.cloud.news.member.service.service.impl;

import com.cloud.news.member.service.service.MemberService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    @Value("${server.port}")
    String port;

    @Override
    public String sayHi(String name) {
        return "hi " + name + " ,i am from port:" + port;
    }
}
