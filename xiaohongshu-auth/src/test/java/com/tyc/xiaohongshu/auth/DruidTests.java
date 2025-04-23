package com.tyc.xiaohongshu.auth;

import com.alibaba.druid.filter.config.ConfigTools;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.PostMapping;

@SpringBootTest
@Slf4j
public class DruidTests {
    @Test
    @SneakyThrows
    @PostMapping("/test")
    public void testEncodePassword() {
        String password = "123456";
        String[] arr = ConfigTools.genKeyPair(512);
        // 私钥
        log.info("privateKey: {}", arr[0]);
        // 公钥
        log.info("publicKey: {}", arr[1]);

        String encodePassword  = ConfigTools.encrypt(arr[0], password);
        log.info("encodePassword: {}", encodePassword);
        // int i = 1/0;
    }

}
