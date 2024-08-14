package com.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import static org.springframework.context.annotation.ComponentScan.*;

@Configuration
@ComponentScan(
        excludeFilters = @Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
) // @Component 가 붙은 클래스를 모두 읽어들여 자동으로 스프링 빈으로 등록
public class AutoAppConfig {
}
