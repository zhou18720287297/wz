package com.wz.jiangsu.testnetvine;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;
import org.junit.jupiter.api.*;

import java.util.Properties;
import java.util.concurrent.Future;

/**
 * @program: wz
 * @author: wangzhou
 * @create: 2023-11-29 18:10
 * @description:
 **/
public class TestProducer {

    static Properties properties;
    static KafkaProducer<String, String> kafkaProducer;
    @BeforeAll
    static void initAll() {
        properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"10.25.10.16:9092");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class);
        properties.put(ProducerConfig.BATCH_SIZE_CONFIG, 16 * 1024* 2);
        properties.put(ProducerConfig.LINGER_MS_CONFIG,2);
        properties.put(ProducerConfig.BUFFER_MEMORY_CONFIG,33554432);
        properties.put(ProducerConfig.COMPRESSION_TYPE_CONFIG,"snappy");
        properties.put(ProducerConfig.TRANSACTIONAL_ID_CONFIG,"transactional_id_01");
        kafkaProducer = new KafkaProducer(properties);

        // 执行一些全局初始化操作
        System.out.println("init .........");
    }

//        @BeforeEach
//    void init() {
//        // 执行一些初始化操作
//    }

    @Test
    @DisplayName("测试 Kafka 普通异步调用")
    void customProducer () {

        for (int i = 0; i < 5; i++) {
            kafkaProducer.send(new ProducerRecord<>("testTopic","message:" + i));
        }
    }

    @Test
    @DisplayName("测试 Kafka 带回调函数的异步调用")
    void customProducerCallback () {

        for (int i = 0; i < 5; i++) {
            kafkaProducer.send(new ProducerRecord<>("testTopic", "message:" + i),
                    new Callback() {
                        @Override
                        public void onCompletion(RecordMetadata metadata, Exception exception) {
                            if (exception == null) {
                                System.out.println("主题:" + metadata.topic() + ",分区:" + metadata.partition());
                            }else {
                                exception.printStackTrace();
                            }
                        }
                    });
        }
    }

    /**
     * 返回一个 RecordMetadata 对象
     * @throws Exception
     */
    @Test
    @DisplayName("同步发送 API")
    void customProducerCallbackSync() throws Exception {
        Future<RecordMetadata> future = kafkaProducer.send(new ProducerRecord<>("testTopic", "消息是--AAAA"),
                new Callback() {
                    @Override
                    public void onCompletion(RecordMetadata metadata, Exception exception) {
                        if (exception == null) {
                            System.out.println("主题:" + metadata.topic() + ",分区:" + metadata.partition());
                        } else {
                            exception.printStackTrace();
                        }
                    }
                });
        RecordMetadata recordMetadata = future.get();
        System.out.println(">>>>" + recordMetadata);

    }

    @Test
    @DisplayName("开启事物发送信息")
    void customProducerCallbackTransactions() throws Exception {
        kafkaProducer.initTransactions();

        kafkaProducer.beginTransaction();

        try {
            Future<RecordMetadata> future = kafkaProducer.send(new ProducerRecord<>("testTopic", "消息是--AAAA"),
                    new Callback() {
                        @Override
                        public void onCompletion(RecordMetadata metadata, Exception exception) {
                            if (exception == null) {
                                System.out.println("主题:" + metadata.topic() + ",分区:" + metadata.partition());
                            } else {
                                exception.printStackTrace();
                            }
                        }
                    });
//            int i = 1/0;
            kafkaProducer.commitTransaction();
        } catch (Exception e) {
            kafkaProducer.abortTransaction();
        }


    }

    @Test
    @Disabled("此测试暂时禁用")
    void mySecondTest() {
        // 测试逻辑
    }

//    @AfterEach
//    void tearDown() {
//        // 执行一些清理操作
//    }

    @AfterAll
    static void tearDownAll() {
        kafkaProducer.close();
        // 执行一些全局清理操作
        System.out.println("finally ...");
    }
}
