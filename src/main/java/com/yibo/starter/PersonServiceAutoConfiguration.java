package com.yibo.starter;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 配置注解
@EnableConfigurationProperties(PersonProperties.class) // 开启指定类的配置
@ConditionalOnClass(Person.class)// 当PersonService这个类在类路径中时，且当前容器中没有这个Bean的情况下，开始自动配置
@ConditionalOnProperty(prefix = "person", value = "enabled", matchIfMissing = true)// 指定的属性是否有指定的值
public class PersonServiceAutoConfiguration {
    private final PersonProperties properties;

    public PersonServiceAutoConfiguration(PersonProperties properties) {
        this.properties = properties;
    }

    @Bean
    @ConditionalOnMissingBean(Person.class)// 当容器中没有指定Bean的情况下，自动配置PersonService类
    public Person personService() {
        return new Person(properties);
    }
}