package com.tyc.xiaohongshu.user.kv.biz.service;

import com.tyc.xiaohongshu.framework.common.exception.BizException;
import com.tyc.xiaohongshu.framework.common.response.Response;
import com.tyc.xiaohongshu.user.kv.dto.req.DeleteNoteContentReqDTO;
import com.tyc.xiaohongshu.user.kv.dto.req.FindNoteContentReqDTO;
import com.tyc.xiaohongshu.user.kv.dto.rsp.FindNoteContentRspDTO;
import com.tyc.xiaohongshu.user.kv.dto.req.AddNoteContentReqDTO;

public interface NoteContentService {

    /**
     * 添加笔记内容
     *
     * @param addNoteContentReqDTO
     * @return
     */
    Response<?> addNoteContent(AddNoteContentReqDTO addNoteContentReqDTO);

    /**
     * 查询笔记内容
     *
     * @param findNoteContentReqDTO
     * @return
     */
    Response<FindNoteContentRspDTO> findNoteContent(FindNoteContentReqDTO findNoteContentReqDTO) throws BizException;
    /**
     * 删除笔记内容
     *
     * @param deleteNoteContentReqDTO
     * @return
     */
    Response<?> deleteNoteContent(DeleteNoteContentReqDTO deleteNoteContentReqDTO);


}