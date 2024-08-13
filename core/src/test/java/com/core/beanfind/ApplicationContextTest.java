package com.core.beanfind;

import com.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 조회")
    void findAllBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();// 모든 빈 조회
        for (String names : beanDefinitionNames) {
            Object bean = ac.getBean(names);
            System.out.println(bean);
        }
    }

    @Test
    @DisplayName("모든 애플리케이션 빈 조회")
    void findAllApplicationBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();// 모든 빈 조회
        for (String names : beanDefinitionNames) {
            BeanDefinition bean = ac.getBeanDefinition(names);

            //Role ROLE_APPLICATION: 직접 등록한 애플리케이션 빈
            //Role ROLE_INFRASTRUCTURE: 스프링이 내부에서 사용하는 빈
            if (bean.getRole() == BeanDefinition.ROLE_APPLICATION) {
                Object bean2 = ac.getBean(names);
                System.out.println(bean2);
            }
        }
    }
}
