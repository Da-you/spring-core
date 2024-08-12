package com.core;


import com.core.member.Grade;
import com.core.member.Member;
import com.core.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        Member member = new Member(1L, "memberA", Grade.VIP); // 1L is a long type
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.printf("new member = " + member.getName());
        System.out.printf("find member = " + findMember.getName());
    }
}

