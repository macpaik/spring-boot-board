package com.macxpaik.springbootboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.filter.HiddenHttpMethodFilter;

import java.util.Arrays;

@SpringBootApplication
@EnableJpaAuditing
public class SpringBootBoardApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootBoardApplication.class, args);
    }

    @Bean
    public FilterRegistrationBean hiddenHttpMethodFilter() {
        FilterRegistrationBean filterRegBean = new FilterRegistrationBean(new HiddenHttpMethodFilter());
        filterRegBean.setUrlPatterns(Arrays.asList("/*"));
        return filterRegBean;
    }

}
