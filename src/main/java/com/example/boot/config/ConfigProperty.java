package com.example.boot.config;

import lombok.Data;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

/**
 * Created
 * author:  lqk
 * 2019/8/29 10:25   加载配置文件
 */

@Data
@SpringBootConfiguration
@ConfigurationProperties(prefix = "server")                         //资源文件前缀
@PropertySource(value = "classpath:resource.properties")            //设置资源文件的地址
@EnableConfigurationProperties(ConfigProperty.class)                //开启@ConfigurationProperties
public class ConfigProperty {

    private String payUrl;

}
