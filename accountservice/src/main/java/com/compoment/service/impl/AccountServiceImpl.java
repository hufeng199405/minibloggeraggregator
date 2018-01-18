package com.compoment.service.impl;

import com.compoment.captcha.AccountCaptchaService;
import com.compoment.model.SignUpRequest;
import com.compoment.service.AccountService;
import com.component.account.service.AccountPersistService;
import com.component.email.EmailService;

/**
 * 类备注：
 *
 * @author Administrator
 * @version 1.0
 * @date 2018-01-18 15:31
 * @desc
 * @since 1.8
 */
public class AccountServiceImpl implements AccountService {

    /**
     * 邮箱操作service
     */
    private EmailService emailService;

    /**
     * 账户操作service
     */
    private AccountPersistService accountPersistService;

    /**
     * 验证码验证service
     */
    private AccountCaptchaService accountCaptchaService;

    /**
     * 生成验证码主键
     */
    @Override
    public String generateCaptchaKey() throws Exception {

        return accountCaptchaService.generateCaptchaKey();
    }

    /**
     * 生成验证码图片
     */
    @Override
    public byte[] generateCaptchaImage(String captchaKey) throws Exception {

        return accountCaptchaService.generateCaptchaImage(captchaKey);
    }

    /**
     * 注册账户
     */
    @Override
    public void signIn(SignUpRequest request) throws Exception {

        
    }

    @Override
    public void activate(String activationNumber) throws Exception {

    }

    @Override
    public void login(String id, String password) throws Exception {

    }
}
