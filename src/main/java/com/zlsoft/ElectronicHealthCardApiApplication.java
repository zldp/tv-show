package com.zlsoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ElectronicHealthCardApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElectronicHealthCardApiApplication.class, args);
    }

    /**
     * 开启方法级别验证
     * @return
     */
    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor() {
        return new MethodValidationPostProcessor();
    }

    /**
     * 调用接口模板
     */
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
