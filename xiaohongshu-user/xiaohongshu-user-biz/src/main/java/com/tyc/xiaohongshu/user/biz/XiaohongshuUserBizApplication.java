package com.tyc.xiaohongshu.user.biz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@MapperScan("com.tyc.xiaohongshu.user.biz.domain.mapper")
@SpringBootApplication
@EnableFeignClients(basePackages = "com.tyc.xiaohongshu")
public class XiaohongshuUserBizApplication {

    public static void main(String[] args) {
        SpringApplication.run(XiaohongshuUserBizApplication.class, args);
    }
}