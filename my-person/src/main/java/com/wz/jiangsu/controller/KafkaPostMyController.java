package com.wz.jiangsu.controller;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSONObject;
import com.wz.jiangsu.bean.Event;
import com.wz.jiangsu.bean.SecurityEventDataCommonDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.FailureCallback;
import org.springframework.util.concurrent.SuccessCallback;
import org.springframework.web.bind.annotation.*;

/**
 * @program: FlinkTest
 * @author: wangzhou
 * @create: 2023-11-24 15:39
 * @description:
 **/
@RestController
public class KafkaPostMyController {
    @Value("${netvine.security.topic}")
    private String topic;

    @Value("${netvine.security.groupId}")
    private String groupId;

    @Value("${kafka.topic}")
    private String testTopic;

    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;

    /**
     * 测试发送到 102 台机器
     * @param message
     * @return
     */
    @GetMapping("/kafka/post/callbackzero/{message}")
    public String sendCallbackOneMessage0( @PathVariable("message")String  message) {
        System.out.println(message);
        kafkaTemplate.send(testTopic, "wz",message).addCallback(new SuccessCallback<SendResult<String, Object>>() {
            //成功的回调
            @Override
            public void onSuccess(SendResult<String, Object> success) {
                // 消息发送到的topic
                String topic = success.getRecordMetadata().topic();
                // 消息发送到的分区
                int partition = success.getRecordMetadata().partition();
                // 消息在分区内的offset
                long offset = success.getRecordMetadata().offset();

                System.out.println("发送消息成功-安全日志:" + topic + "-" + partition + "-" + offset);
            }
        }, new FailureCallback() {
            //失败的回调
            @Override
            public void onFailure(Throwable throwable) {
                System.out.println("发送消息失败1:" + throwable.getMessage());
            }
        });
        return message;
    }
    /**
     * 测试发送信息-安全审计
     * @param dto 模仿 Kafaka 消息体的实体类
     */
    @PostMapping("/kafka/post/callbackOne/")
    public String sendCallbackOneMessage( @RequestBody SecurityEventDataCommonDto dto) {
        String message = StrUtil.toString(dto);
        String jsonStr = JSONUtil.toJsonStr(dto);
        System.out.println("jsonStr = " + jsonStr);
        System.out.println("message = " + jsonStr);
        kafkaTemplate.send(topic, jsonStr).addCallback(new SuccessCallback<SendResult<String, Object>>() {
            //成功的回调
            @Override
            public void onSuccess(SendResult<String, Object> success) {
                // 消息发送到的topic
                String topic = success.getRecordMetadata().topic();
                // 消息发送到的分区
                int partition = success.getRecordMetadata().partition();
                // 消息在分区内的offset
                long offset = success.getRecordMetadata().offset();

                System.out.println("发送消息成功-安全日志:" + topic + "-" + partition + "-" + offset);
            }
        }, new FailureCallback() {
            //失败的回调
            @Override
            public void onFailure(Throwable throwable) {
                System.out.println("发送消息失败1:" + throwable.getMessage());
            }
        });
        return jsonStr;
    }

    /**
     * 测试发送信息-主机
     * @param dto 模仿 Kafaka 消息体的实体类
     */
    @PostMapping("/kafka/post/callbackTwo/")
    public String sendCallbackOneMessage2( @RequestBody SecurityEventDataCommonDto dto) {
        String message = StrUtil.toString(dto);
        String jsonStr = JSONUtil.toJsonStr(dto);
        System.out.println("jsonStr = " + jsonStr);
        System.out.println("message = " + jsonStr);
        kafkaTemplate.send(topic, jsonStr).addCallback(new SuccessCallback<SendResult<String, Object>>() {
            //成功的回调
            @Override
            public void onSuccess(SendResult<String, Object> success) {
                // 消息发送到的topic
                String topic = success.getRecordMetadata().topic();
                // 消息发送到的分区
                int partition = success.getRecordMetadata().partition();
                // 消息在分区内的offset
                long offset = success.getRecordMetadata().offset();

                System.out.println("发送消息成功-主机日志:" + topic + "-" + partition + "-" + offset);
            }
        }, new FailureCallback() {
            //失败的回调
            @Override
            public void onFailure(Throwable throwable) {
                System.out.println("发送消息失败1:" + throwable.getMessage());
            }
        });

        return jsonStr;
    }

    /**
     * 测试发送信息- 入侵
     * @param dto 模仿 Kafaka 消息体的实体类
     */
    @PostMapping("/kafka/post/callbackthree/")
    public String sendCallbackOneMessage3( @RequestBody SecurityEventDataCommonDto dto) {
        String message = StrUtil.toString(dto);
        String jsonStr = JSONUtil.toJsonStr(dto);
        System.out.println("jsonStr = " + jsonStr);
        System.out.println("message = " + jsonStr);
        kafkaTemplate.send(topic, jsonStr).addCallback(new SuccessCallback<SendResult<String, Object>>() {
            //成功的回调
            @Override
            public void onSuccess(SendResult<String, Object> success) {
                // 消息发送到的topic
                String topic = success.getRecordMetadata().topic();
                // 消息发送到的分区
                int partition = success.getRecordMetadata().partition();
                // 消息在分区内的offset
                long offset = success.getRecordMetadata().offset();

                System.out.println("发送消息成功-主机日志:" + topic + "-" + partition + "-" + offset);
            }
        }, new FailureCallback() {
            //失败的回调
            @Override
            public void onFailure(Throwable throwable) {
                System.out.println("发送消息失败1:" + throwable.getMessage());
            }
        });
        return jsonStr;
    }

    /**
     * 测试发送信息- 防火墙
     * @param dto 模仿 Kafaka 消息体的实体类
     */
    @PostMapping("/kafka/post/callbackfour/")
    public String sendCallbackOneMessage4( @RequestBody SecurityEventDataCommonDto dto) {
        String message = StrUtil.toString(dto);
        String jsonStr = JSONUtil.toJsonStr(dto);
        System.out.println("jsonStr = " + jsonStr);
        System.out.println("message = " + jsonStr);
        kafkaTemplate.send(topic, jsonStr).addCallback(new SuccessCallback<SendResult<String, Object>>() {
            //成功的回调
            @Override
            public void onSuccess(SendResult<String, Object> success) {
                // 消息发送到的topic
                String topic = success.getRecordMetadata().topic();
                // 消息发送到的分区
                int partition = success.getRecordMetadata().partition();
                // 消息在分区内的offset
                long offset = success.getRecordMetadata().offset();

                System.out.println("发送消息成功-主机日志:" + topic + "-" + partition + "-" + offset);
            }
        }, new FailureCallback() {
            //失败的回调
            @Override
            public void onFailure(Throwable throwable) {
                System.out.println("发送消息失败1:" + throwable.getMessage());
            }
        });
        return jsonStr;
    }

    /**
     * 测试发送信息- USB
     * @param dto 模仿 Kafaka 消息体的实体类
     */
    @PostMapping("/kafka/post/callbackfive/")
    public String sendCallbackOneMessage5( @RequestBody SecurityEventDataCommonDto dto) {
        String message = StrUtil.toString(dto);
        String jsonStr = JSONUtil.toJsonStr(dto);
        System.out.println("jsonStr = " + jsonStr);
        System.out.println("message = " + jsonStr);
        kafkaTemplate.send(topic, jsonStr).addCallback(new SuccessCallback<SendResult<String, Object>>() {
            //成功的回调
            @Override
            public void onSuccess(SendResult<String, Object> success) {
                // 消息发送到的topic
                String topic = success.getRecordMetadata().topic();
                // 消息发送到的分区
                int partition = success.getRecordMetadata().partition();
                // 消息在分区内的offset
                long offset = success.getRecordMetadata().offset();

                System.out.println("发送消息成功-主机日志:" + topic + "-" + partition + "-" + offset);
            }
        }, new FailureCallback() {
            //失败的回调
            @Override
            public void onFailure(Throwable throwable) {
                System.out.println("发送消息失败1:" + throwable.getMessage());
            }
        });
        return jsonStr;
    }


    /**
     * 测试发送信息-test
     * @param dto
     * @return
     */
    @PostMapping("/test")
    public String getString(@RequestBody Event dto){
        String str = JSONUtil.toJsonStr(dto);
        String str2 = "{\n" +
                "    \"USER\": \"232323\",\n" +
                "    \"timestamp\": 1529860633720,\n" +
                "    \"url\": \"http://uzpxg.gy/wgvdwsufec\"\n" +
                "}";
        Event bean = JSONObject.parseObject(str2, Event.class);
        System.out.println(bean);

        return str;
    }

    /**
     * 测试发送消息给 analusisd_queue
     * @param message
     * @return
     */
    @GetMapping("/kafka/get/callbackOne/")
    public String putMessage(@RequestParam String message){

        String str = "1:/var/log/auth.log:Nov 20 17:23:50 Classicriver sshd[121905]: Accepted password for root from 10.25.16.104 port 51974 ssh2";

        kafkaTemplate.send("analysisd_queue", str).addCallback(new SuccessCallback<SendResult<String, Object>>() {
            //成功的回调
            @Override
            public void onSuccess(SendResult<String, Object> success) {
                // 消息发送到的topic
                String topic = success.getRecordMetadata().topic();
                // 消息发送到的分区
                int partition = success.getRecordMetadata().partition();
                // 消息在分区内的offset
                long offset = success.getRecordMetadata().offset();

                System.out.println("发送消息成功-主机日志:" + topic + "-" + partition + "-" + offset);
            }
        }, new FailureCallback() {
            //失败的回调
            @Override
            public void onFailure(Throwable throwable) {
                System.out.println("发送消息失败1:" + throwable.getMessage());
            }
        });

        return str;
    }

    @GetMapping("/testStr/{str}")
    public String getStr(@PathVariable("str") String str){
        return str;
    }
}
