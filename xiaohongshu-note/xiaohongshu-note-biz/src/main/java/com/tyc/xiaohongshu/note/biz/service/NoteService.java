package com.tyc.xiaohongshu.note.biz.service;

import com.tyc.xiaohongshu.framework.common.exception.BizException;
import com.tyc.xiaohongshu.framework.common.response.Response;
import com.tyc.xiaohongshu.note.biz.model.vo.*;
import com.tyc.xiaohongshu.note.biz.rpc.FindNoteDetailRspVO;
import org.apache.ibatis.annotations.Param;

public interface NoteService {

    /**
     * 笔记发布
     * @param publishNoteReqVO
     * @return
     */
    Response<?> publishNote(PublishNoteReqVO publishNoteReqVO) throws BizException;
    /**
     * 笔记详情
     * @param findNoteDetailReqVO
     * @return
     */
    Response<FindNoteDetailRspVO> findNoteDetail(FindNoteDetailReqVO findNoteDetailReqVO) throws BizException;
    /**
     * 笔记更新
     * @param updateNoteReqVO
     * @return
     */
    Response<?> updateNote(UpdateNoteReqVO updateNoteReqVO) throws BizException;
    /**
     * 删除笔记
     * @param deleteNoteReqVO
     * @return
     */
    Response<?> deleteNote(DeleteNoteReqVO deleteNoteReqVO) throws BizException;

    /**
     * 笔记仅对自己可见
     * @param updateNoteVisibleOnlyMeReqVO
     * @return
     */
    Response<?> visibleOnlyMe(UpdateNoteVisibleOnlyMeReqVO updateNoteVisibleOnlyMeReqVO) throws BizException;
    /**
     * 笔记置顶 / 取消置顶
     * @param topNoteReqVO
     * @return
     */
    Response<?> topNote(TopNoteReqVO topNoteReqVO) throws BizException;

    /**
     * 删除本地笔记缓存
     * @param noteId
     */
    void deleteNoteLocalCache(Long noteId);

    /**
     * 点赞笔记
     * @param likeNoteReqVO
     * @return
     */
    Response<?> likeNote(LikeNoteReqVO likeNoteReqVO) throws BizException;


    /**
     * 取消点赞笔记
     * @param unlikeNoteReqVO
     * @return
     */
    Response<?> unlikeNote(UnlikeNoteReqVO unlikeNoteReqVO) throws BizException;
    /**
     * 收藏笔记
     * @param collectNoteReqVO
     * @return
     */
    Response<?> collectNote(CollectNoteReqVO collectNoteReqVO) throws BizException;
    /**
     * 取消收藏笔记
     * @param unCollectNoteReqVO
     * @return
     */
    Response<?> unCollectNote(UnCollectNoteReqVO unCollectNoteReqVO) throws BizException;

}