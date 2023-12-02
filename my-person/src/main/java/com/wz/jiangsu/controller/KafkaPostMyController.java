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
     * @param id
     * @return
     */
    @GetMapping("/kafka/get/callbackOne/")
    public String putMessage(@RequestParam String id){

        String str = "";

        switch (id){
            case "1":
                str = "1:/var/log/auth.log:Nov 20 17:23:50 Classicriver sshd[121905]: Accepted password for root from 10.25.16.104 port 51974 ssh2";
                break;
            case "2":
                str = "1:df -P:ossec: output: 'df -P': Filesystem     1024-blocks     Used Available Capacity Mounted on";
                break;
            case "3":
                str = "1:df -P:ossec: output: 'df -P': tmpfs               396444     2100    394344       1% /run";
                break;
            case "4":
                str = "1:netstat listening ports:ossec: output: 'netstat listening ports':\\ntcp 0.0.0.0:22 0.0.0.0:* /usr\\ntcp6 :::22 :::* /usr\\ntcp 127.0.0.53:53 0.0.0.0:* 10780/systemd-resol\\nudp 127.0.0.53:53 0.0.0.0:* 10780/systemd-resol\\ntcp 127.0.0.1:631 0.0.0.0:* 942288/cupsd\\ntcp6 ::1:631 :::* 942288/cupsd\\nudp 0.0.0.0:631 0.0.0.0:* 942298/cups-browsed\\nudp 0.0.0.0:5353 0.0.0.0:* 751/avahi-daemon\\nudp6 :::5353 :::* 751/avahi-daemon\\ntcp 127.0.0.1:6010 0.0.0.0:* 1223216/sshd\\ntcp6 ::1:6010 :::* 1223216/sshd\\ntcp 127.0.0.1:6011 0.0.0.0:* 1601678/sshd\\ntcp6 ::1:6011 :::* 1601678/sshd\\ntcp 127.0.0.1:6012 0.0.0.0:* 1602855/sshd\\ntcp6 ::1:6012 :::* 1602855/sshd\\ntcp 127.0.0.1:39605 0.0.0.0:* 1510328/code-1a5daa\\ntcp 127.0.0.1:40195 0.0.0.0:* 1509607/node\\nudp6 :::40861 :::* 751/avahi-daemon\\ntcp 127.0.0.1:42767 0.0.0.0:* 881/containerd\\nudp 0.0.0.0:55014 0.0.0.0:* 751/avahi-daemon";
                break;

            case "5":
//                str = "1:netstat listening ports:ossec: output: 'netstat listening ports':\\ntcp 0.0.0.0:22 0.0.0.0:* /usr\\ntcp6 :::22 :::* /usr\\ntcp 127.0.0.53:53 0.0.0.0:* 10780/systemd-resol\\nudp 127.0.0.53:53 0.0.0.0:* 10780/systemd-resol\\ntcp 127.0.0.1:631 0.0.0.0:* 942288/cupsd\\ntcp6 ::1:631 :::* 942288/cupsd\\nudp 0.0.0.0:631 0.0.0.0:* 942298/cups-browsed\\nudp 0.0.0.0:5353 0.0.0.0:* 751/avahi-daemon\\nudp6 :::5353 :::* 751/avahi-daemon\\ntcp 127.0.0.1:6010 0.0.0.0:* 1223216/sshd\\ntcp6 ::1:6010 :::* 1223216/sshd\\ntcp 127.0.0.1:6011 0.0.0.0:* 1601678/sshd\\ntcp6 ::1:6011 :::* 1601678/sshd\\ntcp 127.0.0.1:6012 0.0.0.0:* 1602855/sshd\\ntcp6 ::1:6012 :::* 1602855/sshd\\ntcp 127.0.0.1:39605 0.0.0.0:* 1510328/code-1a5daa\\ntcp 127.0.0.1:40195 0.0.0.0:* 1509607/node\\nudp6 :::40861 :::* 751/avahi-daemon\\ntcp 127.0.0.1:42767 0.0.0.0:* 881/containerd\\nudp 0.0.0.0:55014 0.0.0.0:* 751/avahi-daemon";
                str = "1:last -n 20:ossec: output: 'last -n 20':\\nroot     pts/2        10.25.16.158     Fri Dec  1 16:43   still logged in\\nroot     pts/2        10.25.16.158     Fri Dec  1 16:42 - 16:43  (00:01)\\nroot     pts/1        10.25.16.158     Fri Dec  1 16:42   still logged in\\nroot     pts/1        10.25.16.158     Fri Dec  1 16:40 - 16:40  (00:00)\\nroot     pts/1        10.25.16.158     Fri Dec  1 14:52 - 16:40  (01:47)\\nroot     pts/0        10.25.16.158     Fri Dec  1 13:58   still logged in\\nroot     pts/1        10.25.16.158     Fri Dec  1 12:03 - 13:04  (01:00)\\nroot     pts/2        10.25.16.158     Fri Dec  1 10:51 - 16:42  (05:51)\\nroot     pts/1        10.25.16.158     Fri Dec  1 10:17 - 12:03  (01:46)\\nroot     pts/0        10.25.16.158     Fri Dec  1 09:43 - 12:57  (03:13)\\nroot     pts/0        10.25.16.158     Thu Nov 30 20:16 - 05:38  (09:22)\\nroot     pts/0        10.25.16.158     Thu Nov 30 16:59 - 20:15  (03:16)\\nroot     pts/3        10.25.16.158     Thu Nov 30 16:54 - 23:05  (06:10)\\nroot     pts/2        10.25.16.158     Thu Nov 30 15:13 - 18:34  (03:20)\\nroot     pts/1        10.25.16.158     Thu Nov 30 09:20 - 18:45  (09:24)\\nroot     pts/0        10.25.16.158     Thu Nov 30 09:19 - 16:59  (07:39)\\nroot     pts/2        10.25.16.158     Wed Nov 29 15:23 - 18:22  (02:59)\\nroot     pts/1        10.25.16.158     Wed Nov 29 11:58 - 18:22  (06:24)\\nroot     pts/0        10.25.16.158     Wed Nov 29 09:43 - 18:22  (08:39)\\nreboot   system boot  6.2.0-37-generic Wed Nov 29 09:40   still running\\nwtmp begins Thu Sep 14 15:46:50 2023";
                break;
            default:
                str = "请输入 1 到 5 这些数字,不要输入这个：" + id + ",[换一个进行输入]";
        }

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
        return str + "my name is wangzhou";
    }
}
