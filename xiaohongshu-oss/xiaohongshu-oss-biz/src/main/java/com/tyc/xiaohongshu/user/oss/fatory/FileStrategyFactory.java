package com.tyc.xiaohongshu.user.oss.fatory;

import com.tyc.xiaohongshu.user.oss.strategy.FileStrategy;
import com.tyc.xiaohongshu.user.oss.strategy.impl.AliyunOSSFileStrategy;
import com.tyc.xiaohongshu.user.oss.strategy.impl.MinioFileStrategy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.commons.lang3.StringUtils;

@RefreshScope
@Configuration
public class FileStrategyFactory {

    @Value("${storage.type}")
    private String strategyType;

    @RefreshScope
    @Bean
    public FileStrategy getFileStrategy() {
        if (StringUtils.equals(strategyType, "minio")) {
            return new MinioFileStrategy();
        } else if (StringUtils.equals(strategyType, "aliyun")) {
            return new AliyunOSSFileStrategy();
        }

        throw new IllegalArgumentException("不可用的存储类型");
    }

}
