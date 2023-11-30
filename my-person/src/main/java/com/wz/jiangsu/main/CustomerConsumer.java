package com.wz.jiangsu.main;


import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Properties;

/**
 * @program: wz
 * @author: wangzhou
 * @create: 2023-11-30 16:12
 * @description:
 **/
public class CustomerConsumer {

    // 0、配置
    static Properties properties = new Properties();

    static {
        // 连接
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"10.25.10.16:9092");
        // 反序列化
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class.getName());
        // 配置消费者组的名字
        properties.put(ConsumerConfig.GROUP_ID_CONFIG,"testConsumer");
    }

    public static void main(String[] args) {

        // 1、创建一个消费者
        KafkaConsumer<String,String> kafkaConsumer = new KafkaConsumer(properties);


        // 2、定义主题 testTopic
        ArrayList<String> topics = new ArrayList<>();
        topics.add("testTopic");
        kafkaConsumer.subscribe(topics);

        // 3、消费数据

        while (true){
            // 按照多长时间去拉取消费的消息
            ConsumerRecords<String,String> consumerRecords = kafkaConsumer.poll(Duration.ofSeconds(10));
            for (ConsumerRecord<String, String> consumerRecord : consumerRecords) {
                System.out.println("网藤科技:" + consumerRecord);
            }
        }

    }

}
