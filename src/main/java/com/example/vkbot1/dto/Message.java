package com.example.vkbot1.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {

    private Long date;
    private Long peerId;
    private Long fromId;
    private String text;
    private Long groupId;

}
