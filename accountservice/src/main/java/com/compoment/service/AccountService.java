package com.compoment.service;

import com.compoment.model.SignUpRequest;

/**
 * 类备注：账户操作服务类
 *
 * @author Administrator
 * @version 1.0
 * @date 2018-01-18 15:08
 * @desc
 * @since 1.8
 */
public interface AccountService {

    /**
     * 生成验证码主键
     *
     * @return
     * @throws Exception
     */
    String generateCaptchaKey() throws Exception;

    /**
     * 生成验证码图片
     *
     * @param captchaKey
     * @return
     * @throws Exception
     */
    byte[] generateCaptchaImage(String captchaKey) throws Exception;

    /**
     * 注册账户
     *
     * @param request
     * @throws Exception
     */
    void signIn(SignUpRequest request) throws Exception;

    /**
     * 通过注册码激活账户
     *
     * @param activationNumber
     * @throws Exception
     */
    void activate(String activationNumber) throws Exception;

    /**
     * 登录账户
     *
     * @param id
     * @param password
     * @throws Exception
     */
    void login(String id,String password) throws Exception;
}
