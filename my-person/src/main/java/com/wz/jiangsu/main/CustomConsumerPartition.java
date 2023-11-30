package com.wz.jiangsu.main;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Properties;

/**
 * @program: wz
 * @author: wangzhou
 * @create: 2023-11-30 16:54
 * @description:
 **/
public class CustomConsumerPartition {
    public static void main(String[] args) {
        Properties properties = new Properties();
        // 连接
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"10.25.10.16:9092");
        // 反序列化
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class.getName());
        // 配置消费者组的名字
        properties.put(ConsumerConfig.GROUP_ID_CONFIG,"testConsumer");

        KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<>(properties);

        TopicPartition topicPartition = new TopicPartition("testTopic", 0);
        ArrayList<TopicPartition> topicPartitions = new ArrayList<>();
        topicPartitions.add(topicPartition);
        kafkaConsumer.assign(topicPartitions);

        while (true){
            ConsumerRecords<String, String> consumerRecords = kafkaConsumer.poll(Duration.ofSeconds(3));

            for (ConsumerRecord<String, String> consumerRecord : consumerRecords) {
                System.out.println("wangteng>>>:" + consumerRecord);
            }
        }

    }
}
