package com.example.vkbot1.service;

import com.example.vkbot1.config.VkProperties;

import java.net.URI;

import com.example.vkbot1.dto.MessageSend;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;

@Component
@RequiredArgsConstructor
public class VkUriCreator {

    private final VkProperties vkProperties;
    private final ObjectMapper objectMapper;

    public URI createUri(MessageSend messageSend) {
        MultiValueMap<String, String> map = objectMapper.convertValue(messageSend, LinkedMultiValueMap.class);

        return UriComponentsBuilder.fromHttpUrl("https://api.vk.com/method/messages.send")
                .queryParam("access_token", vkProperties.getToken())
                .queryParam("v", vkProperties.getVersion())
                .queryParams(map)
                .build()
                .toUri();
    }
}
