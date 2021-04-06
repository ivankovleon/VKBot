package com.example.vkbot1.service;

import com.example.vkbot1.dto.Callback;
import com.example.vkbot1.config.VkProperties;
import com.example.vkbot1.dto.Message;
import com.example.vkbot1.dto.MessageSend;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CallbackService {

    private final VkProperties vkProperties;
    private final VkUriCreator vkUriCreator;

    public String handleCallback(Callback callbackBody) {
        switch (Objects.requireNonNull(callbackBody.getType())) {
            case "confirmation":
                return vkProperties.getConfirmation();

            case "message_new":
                Message message = parseMessage(callbackBody);
                handleMessage(message);
                return "ok";

            default:
                return "ok";
        }
    }

    public static Message parseMessage(Callback callback) {
        Map<String, Object> map = callback.getObject();

        return Message.builder()
                .date(Long.parseLong(String.valueOf(map.get("date"))))
                .peerId(Long.parseLong(String.valueOf(map.get("peer_id"))))
                .fromId(Long.parseLong(String.valueOf(map.get("from_id"))))
                .text(String.valueOf(map.get("text")))
                .groupId(callback.getGroupId())
                .build();

    }

    private void handleMessage(Message message) {
        MessageSend messageSend = MessageSend.builder()
                .peerId(message.getPeerId())
                .message("Вы сказали: ".concat(message.getText()))
                .groupId(message.getGroupId())
                .build();
        send(messageSend);
    }

    private void send(MessageSend messageSend) {
        messageSend.setRandomId(0L);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForEntity(vkUriCreator.createUri(messageSend), null, Callback.class);
    }

}
