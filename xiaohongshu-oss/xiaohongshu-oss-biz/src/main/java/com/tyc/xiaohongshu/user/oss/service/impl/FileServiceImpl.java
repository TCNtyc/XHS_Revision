package com.tyc.xiaohongshu.user.oss.service.impl;

import com.tyc.xiaohongshu.framework.common.response.Response;
import com.tyc.xiaohongshu.user.oss.strategy.FileStrategy;
import com.tyc.xiaohongshu.user.oss.service.FileService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@Slf4j
public class FileServiceImpl implements FileService {

    @Resource
    private FileStrategy fileStrategy;

//    private static final String BUCKET_NAME = "xiaohongshu-revision";
     private static final String BUCKET_NAME = "xiaohashu";

    @Override
    public Response<?> uploadFile(MultipartFile file) {
        // 上传文件
        String url = fileStrategy.uploadFile(file, BUCKET_NAME);

        return Response.success(url);
    }
}