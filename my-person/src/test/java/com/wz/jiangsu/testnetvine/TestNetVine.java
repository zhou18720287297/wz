package com.wz.jiangsu.testnetvine;

import com.alibaba.fastjson.JSONObject;
import com.wz.jiangsu.bean.SecurityEventDataCommonDto;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.junit.jupiter.api.*;

import java.util.Properties;

/**
 * @program: wz
 * @author: wangzhou
 * @create: 2023-11-28 11:58
 * @description:
 **/
//@SpringBootTest
 class TestNetVine {
    @BeforeAll
    static void initAll() {
        // 执行一些全局初始化操作
        System.out.println("init .........");
    }

//    @BeforeEach
//    void init() {
//        // 执行一些初始化操作
//    }

    @Test
    @DisplayName("测试 String.format 方法")
    void myFirstTest() {
        // 测试逻辑
       String str = "空指针异常";
       String exMessage = String.format("反序列化 Kafka 消息出现异常,异常信息是:%s", str);
       System.out.println(exMessage);
    }

   @Test
   @DisplayName("测试 fast 的JSONOBJECT 反序列化方法")
   void JsonObjectTest() {
      // 测试逻辑
      String str = "{\n" +
              "    \"data_type\": \"EVENT_AUDIT_THREATSYSLOG\",\n" +
              "    \"agent_ip\": \"127.0.0.1\",\n" +
              "    \"ts\": 1697016960,\n" +
              "    \"uuid\": \"654f0db4-303e-4829-9707-e39ba48a2001\",\n" +
              "    \"seq\": \"1-1\",\n" +
              "    \"payload\": {\n" +
              "        \"type\": 2,\n" +
              "        \"severity\": 3,\n" +
              "        \"action\": 1,\n" +
              "        \"name\": \"???OS-VXWORK SUrgent11 RCE??LSRR??\",\n" +
              "        \"srcIp\": \"127.0.0.1\",\n" +
              "        \"dstIp\": \"127.0.0.1\",\n" +
              "        \"srcMac\": \"00:00:00:00:00:00\",\n" +
              "        \"dstMac\": \"\",\n" +
              "        \"srcPort\": \"20\",\n" +
              "        \"dstPort\": \"80\"\n" +
              "    }\n" +
              "}";
      for (int i = 1; i <= 100000; i++) {
          SecurityEventDataCommonDto securityEventDataCommonDto = null;
          try {
              securityEventDataCommonDto = JSONObject.parseObject(str, SecurityEventDataCommonDto.class);
          } catch (Exception e) {
              System.out.println("异常；；");
              throw new RuntimeException(e);
          }
          System.out.println(i + "::: " + securityEventDataCommonDto);
      }
   }

    @Test
    @DisplayName("测试 Kafka 普通异步调用")
    void customProducer () {
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"10.25.10.103:9092");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class);
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
        // 执行一些全局清理操作
        System.out.println("finally ...");
    }
}
