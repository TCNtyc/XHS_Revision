package com.tyc.xiaohongshu.user.biz.service;

import com.tyc.xiaohongshu.framework.common.exception.BizException;
import com.tyc.xiaohongshu.framework.common.response.Response;
import com.tyc.xiaohongshu.user.biz.model.vo.UpdateUserInfoReqVO;
import com.tyc.xiaohongshu.user.dto.req.*;
import com.tyc.xiaohongshu.user.dto.resp.FindUserByIdRspDTO;
import com.tyc.xiaohongshu.user.dto.resp.FindUserByPhoneRspDTO;

import java.util.List;

public interface UserService {

    /**
     * 更新用户信息
     *
     * @param updateUserInfoReqVO
     * @return
     */
    Response<?> updateUserInfo(UpdateUserInfoReqVO updateUserInfoReqVO) throws BizException;
    /**
     * 用户注册
     *
     * @param registerUserReqDTO
     * @return
     */
    Response<Long> register(RegisterUserReqDTO registerUserReqDTO);

    /**
     * 根据手机号查询用户信息
     *
     * @param findUserByPhoneReqDTO
     * @return
     */
    Response<FindUserByPhoneRspDTO> findByPhone(FindUserByPhoneReqDTO findUserByPhoneReqDTO) throws BizException;
    /**
     * 更新密码
     *
     * @param updateUserPasswordReqDTO
     * @return
     */
    Response<?> updatePassword(UpdateUserPasswordReqDTO updateUserPasswordReqDTO);
    /**
     * 根据用户 ID 查询用户信息
     *
     * @param findUserByIdReqDTO
     * @return
     */
    Response<FindUserByIdRspDTO> findById(FindUserByIdReqDTO findUserByIdReqDTO) throws BizException;
    /**
     * 批量根据用户 ID 查询用户信息
     *
     * @param findUsersByIdsReqDTO
     * @return
     */
    Response<List<FindUserByIdRspDTO>> findByIds(FindUsersByIdsReqDTO findUsersByIdsReqDTO);

}
