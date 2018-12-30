package com.zhuge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

/**
 * @Title: MySpringApplication
 * @Description:
 * @author: zhuge
 * @date: 2018/12/30 20:09
 */

@SpringBootApplication
public class MySpringApplication {
    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(MySpringApplication.class, args);

        RedisTemplate<String, String> template = (RedisTemplate<String, String>) ctx.getBean("redisTemplate");
        template.convertAndSend("test", "A message received from redis !");
    }

    @Bean
    public MessageListener messageListener() {
        return new MessageListenerImpl();
    }

    @Bean
    public MessageListenerAdapter listenerAdapter(@Autowired MessageListener messageListener) {
        return new MessageListenerAdapter(messageListener, "onMessage");
    }

    @Bean
    public RedisMessageListenerContainer container(@Autowired RedisConnectionFactory connectionFactory,
                                                   @Autowired MessageListenerAdapter adapter) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.addMessageListener(adapter, new PatternTopic("test"));
        return container;
    }
}
