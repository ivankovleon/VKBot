package com.example.vkbot1.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class Callback {

    private String type;
    private Map<String, Object> object;
    private Long groupId;
    private String eventId;
    private String secret;
}
