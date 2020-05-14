package org.mc.study.client.message.kafka.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author machao
 * @date 2020-05-14
 */

@Component
public class ConsumerListener {

    @KafkaListener(topics = "test_topic")
    public void acceptMessage(String message) {
        System.out.println(message);
    }

}
