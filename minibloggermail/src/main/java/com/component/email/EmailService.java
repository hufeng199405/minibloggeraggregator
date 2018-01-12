package com.component.email;

/**
 * 邮箱服务接口
 *
 * @author Administrator
 * @version 1.0
 * @date 2017-12-16 11:29
 * @desc
 * @since 1.8
 */
public interface EmailService {

    /**
     * 发送邮件
     *
     * @param to      接收地址
     * @param subject 主题
     * @param content 内容
     * @param isHtml  是否是html
     * @throws Exception
     */
    void sendMail(String to, String subject, String content, boolean isHtml) throws Exception;
}
