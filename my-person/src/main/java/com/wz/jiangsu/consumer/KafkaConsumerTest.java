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
public class KafkaConsumerTest {

    @Value("${kafka.topic}")
    private String testTopic;

    // 消费监听
//    @KafkaListener(topics = {"analysisd_alert_log"})
//    public void onMessage1(ConsumerRecord<?, ?> record) {
//        System.out.println("+++++++++++++++++");
//        String value = (String) record.value();
//        System.out.println(value);
//
//    }

    @KafkaListener(topics = {"analysisd_alert_json"})
    public void onMessage2(ConsumerRecord<?, ?> record) {
        System.out.println("=============");
        String value = (String) record.value();
        System.out.println(value);
    }

    @KafkaListener(topics = {"analysisd_alert_json"})
    public void onMessage21(ConsumerRecord<?, ?> record) {
        System.out.println("-------------");
        String value = (String) record.value();
        System.out.println(value);
    }


    @KafkaListener(topics = {"testTopic"},groupId = "aaa")
    public void onMessage3(ConsumerRecord<?, ?> record) {
        System.out.println(record + "：103机器的 Kafka");
        System.out.println("aaaa:bbb=============");
        String value = (String) record.value();
        System.out.println(value);
    }

    @KafkaListener(topics = {"testTopic"},groupId = "bbb")
    public void onMessage4(ConsumerRecord<?, ?> record) {
        System.out.println(record + "：103机器的 Kafka");
        System.out.println("bbb:bbb=============");
        String value = (String) record.value();
        System.out.println(value);
    }
}
