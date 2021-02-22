package com.zk.utils;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

//表示这个类是一个读取配置文件的类
@Configuration // 这个注解竟然也是component注解

//指定配置的一些属性,其中的prefix表示前缀
@ConfigurationProperties(prefix = "com.haozz.opensource")

//指定所读取的配置文件的路径
@PropertySource(value = "classpath:resource.properties")
@Data
public class Resource {

    private String name;
    private String website;
    private String language;

}