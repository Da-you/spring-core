package com.core;


import com.core.discount.DiscountPolicy;
import com.core.discount.FixDiscountPolicy;
import com.core.member.MemberRepository;
import com.core.member.MemberService;
import com.core.member.MemberServiceImpl;
import com.core.member.MemoryMemberRepository;
import com.core.order.OrderService;
import com.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 스프링 설정정보는 항상 @Configuration을 붙여야 한다.
@Configuration // 애플리케이션의 설정 정보라는 의미, CGLIB라는 라이브러리를 사용해 싱글톤을 보장해줌
public class AppConfig {
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }
}
