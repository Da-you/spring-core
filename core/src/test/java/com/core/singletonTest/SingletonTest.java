package com.core.singletonTest;

import com.core.AppConfig;
import com.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingletonTest {


    @Test
    @DisplayName("스프링이 없는 순순 DI 컨테이너")
    void pureTest(){
        AppConfig appConfig = new AppConfig();

        MemberService memberService1 = appConfig.memberService();
        MemberService memberService2= appConfig.memberService();
        // 호출시 마다 참조값이 다른 객체를 호출
        System.out.println(memberService1);
        System.out.println(memberService2);

    }

    @Test
    @DisplayName("싱클톤 테스트")
    void singleton(){
        SingletonService service1 = SingletonService.getInstance();
        SingletonService service2 = SingletonService.getInstance();

        System.out.println(service1);
        System.out.println(service2);
    }
    @Test
    @DisplayName("스프링컨테이너")
    void springContainerTest(){
//        AppConfig appConfig = new AppConfig();
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService1 = ac.getBean("memberService", MemberService.class);
        MemberService memberService2= ac.getBean("memberService", MemberService.class);
        // 호출시 마다 참조값이 다른 객체를 호출
        System.out.println(memberService1);
        System.out.println(memberService2);
        Assertions.assertThat(memberService1).isSameAs(memberService2);

    }

}
