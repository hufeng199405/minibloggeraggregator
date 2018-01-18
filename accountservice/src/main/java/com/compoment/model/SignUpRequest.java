package com.compoment.model;

/**
 * 类备注：用户操作业务处理vo类
 *
 * @author hufeng
 * @version 1.0
 * @date 2018-01-18 15:12
 * @desc
 * @since 1.8
 */
public class SignUpRequest {

    /**
     * 登录密码
     */
    private String password;

    /**
     * 确认登录密码
     */
    private String confirmPassword;

    /**
     * 验证码key
     */
    private String captchaKey;

    /**
     * 验证码 value
     */
    private String captchaVaule;

    /**
     * 账户主键
     */
    private String id;

    /**
     * 账户姓名
     */
    private String name;

    /**
     * 账户邮箱
     */
    private String email;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getCaptchaKey() {
        return captchaKey;
    }

    public void setCaptchaKey(String captchaKey) {
        this.captchaKey = captchaKey;
    }

    public String getCaptchaVaule() {
        return captchaVaule;
    }

    public void setCaptchaVaule(String captchaVaule) {
        this.captchaVaule = captchaVaule;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
