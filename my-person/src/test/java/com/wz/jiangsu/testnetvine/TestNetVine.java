package com.wz.jiangsu.testnetvine;

import org.junit.jupiter.api.*;

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
