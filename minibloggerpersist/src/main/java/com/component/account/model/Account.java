package com.component.account.model;

/**
 * 账户实体
 *
 * @author Administrator
 * @version 1.0
 * @date 2017-12-16 11:29
 * @desc
 * @since 1.8
 */
public class Account {

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

    /**
     * 账户密码
     */
    private String password;

    /**
     * 是否已激活
     */
    private boolean activated;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }
}
