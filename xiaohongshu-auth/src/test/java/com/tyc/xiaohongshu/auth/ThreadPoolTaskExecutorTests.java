package com.tyc.xiaohongshu.auth;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@SpringBootTest
@Slf4j
public class ThreadPoolTaskExecutorTests {
    @Resource
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Test
    public void test() throws InterruptedException {
        threadPoolTaskExecutor.submit(()-> log.info("线程池测试"));
    }
}
