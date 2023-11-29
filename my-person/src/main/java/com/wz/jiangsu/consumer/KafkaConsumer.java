package com.wz.jiangsu.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @program: wz
 * @author: wangzhou
 * @create: 2023-11-28 14:23
 * @description:
 **/
@Component
public class KafkaConsumer {

    @Value("${kafka.topic}")
    private String testTopic;

    // 消费监听
    @KafkaListener(topics = {"analysisd_alert_log"})
    public void onMessage1(ConsumerRecord<?, ?> record) {
        System.out.println("+++++++++++++++++");
        String value = (String) record.value();
        System.out.println(value);

    }

    @KafkaListener(topics = {"analysisd_alert_json"})
    public void onMessage2(ConsumerRecord<?, ?> record) {
        System.out.println("=============");
        String value = (String) record.value();
        System.out.println(value);
    }


    @KafkaListener(topics = {"testTopic"})
    public void onMessage3(ConsumerRecord<?, ?> record) {
        System.out.println(record + "：102机器的 Kafka");
        System.out.println("=============");
        String value = (String) record.value();
        System.out.println(value);

    }
}
