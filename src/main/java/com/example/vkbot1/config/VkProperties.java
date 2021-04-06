package com.example.vkbot1.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@Data
@PropertySource(value = "classpath:vk.properties")
@ConfigurationProperties(prefix = "vk")
public class VkProperties {

    String token;
    String version;
    String secret;
    String confirmation;
}
