package com.wz.jiangsu.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @program: wz
 * @author: wangzhou
 * @create: 2023-11-28 14:23
 * @description:
 **/
@Component
public class KafkaConsumer {

    @Value("${kafka.topic}")
    private  String testTopic;
    // 消费监听
    @KafkaListener(topics = {"analysisd_alert_log"})
    public void onMessage1(List<ConsumerRecord<?, ?>> records){
        System.out.println("=================");

        String str = (String)records.get(0).value();
        System.out.println(str);



        // 消费的哪个topic、partition的消息,打印出消息内容
//        records.forEach(record -> {
//            System.out.println("简单消费Topic："+record.topic()+"**分区"+record.partition()+"**值内容"+record.value());
//        });

    }

    @KafkaListener(topics = {"analysisd_alert_json"})
    public void onMessage2(List<ConsumerRecord<?, ?>> records){
        System.out.println("++++++++++++");
        String value = (String) records.get(0).value();
        System.out.println(value);

//        records.forEach(record -> {
//            System.out.println("简单消费Topic："+record.topic()+"**分区"+record.partition()+"**值内容"+record.value());
//        });
    }


    @KafkaListener(topics = {"testTopic"})
    public void onMessage3(List<ConsumerRecord<String, String>> record){
        System.out.println(record);
        // 消费的哪个topic、partition的消息,打印出消息内容
        record.forEach(n -> System.out.println(n.value()));
//        System.out.println("简单消费Topic："+record.topic()+"**分区"+record.partition()+"**值内容"+record.value());
    }

    //    @KafkaListener(topics = {"aaa"})
//    public void onMessage3(ConsumerRecord<?, ?> record){
//        // 消费的哪个topic、partition的消息,打印出消息内容
//        System.out.println("简单消费Topic："+record.topic()+"**分区"+record.partition()+"**值内容"+record.value());
//    }



}
