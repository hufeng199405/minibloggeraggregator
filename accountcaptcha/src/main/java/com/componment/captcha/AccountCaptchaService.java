package com.componment.captcha;

import java.util.List;

public interface AccountCaptchaService {

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
     * 验证用户反馈的主键和值
     *
     * @param captchaKey
     * @param captchaValue
     * @return
     * @throws Exception
     */
    boolean validateCaptcha(String captchaKey, String captchaValue) throws Exception;

    List<String> getpredefinedTest();

    void setPreDefinedTexts(List<String> preDefinedTexts);
}
