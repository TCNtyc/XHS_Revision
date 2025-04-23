package com.tyc.xiaohongshu.user.kv.api;

import com.tyc.xiaohongshu.framework.common.response.Response;
import com.tyc.xiaohongshu.user.kv.constant.ApiConstants;
import com.tyc.xiaohongshu.user.kv.dto.req.DeleteNoteContentReqDTO;
import com.tyc.xiaohongshu.user.kv.dto.req.FindNoteContentReqDTO;
import com.tyc.xiaohongshu.user.kv.dto.rsp.FindNoteContentRspDTO;
import com.tyc.xiaohongshu.user.kv.dto.req.AddNoteContentReqDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = ApiConstants.SERVICE_NAME)
public interface KeyValueFeignApi {

    String PREFIX = "/kv";

    @PostMapping(value = PREFIX + "/note/content/add")
    Response<?> addNoteContent(@RequestBody AddNoteContentReqDTO addNoteContentReqDTO);
    @PostMapping(value = PREFIX + "/note/content/find")
    Response<FindNoteContentRspDTO> findNoteContent(@RequestBody FindNoteContentReqDTO findNoteContentReqDTO);
    @PostMapping(value = PREFIX + "/note/content/delete")
    Response<?> deleteNoteContent(@RequestBody DeleteNoteContentReqDTO deleteNoteContentReqDTO);
}