package com.zhuge;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

@Component
public class MessageListenerImpl implements MessageListener {
    @Override
    public void onMessage(Message message, byte[] pattern) {
        System.out.println(new String(message.getBody(), StandardCharsets.UTF_8));
    }
}
