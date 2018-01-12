package com.component.account.service;

import com.component.account.model.Account;

/**
 * 账户服务层接口
 *
 * @author Administrator
 * @version 1.0
 * @date 2017-12-16 11:29
 * @desc
 * @since 1.8
 */
public interface AccountPersistService {

    /**
     * 账户注册
     *
     * @param account
     * @return
     * @throws Exception
     */
    String createAccount(Account account) throws Exception;

    /**
     * 查询账户信息
     *
     * @param id
     * @return
     * @throws Exception
     */
    Account selectAccount(String id) throws Exception;

    /**
     * 修改账户信息
     *
     * @param account
     * @return
     * @throws Exception
     */
    String updateAccount(Account account) throws Exception;

    /**
     * 删除账户信息
     *
     * @param id
     * @return
     * @throws Exception
     */
    String deleteAccount(String id) throws Exception;
}
