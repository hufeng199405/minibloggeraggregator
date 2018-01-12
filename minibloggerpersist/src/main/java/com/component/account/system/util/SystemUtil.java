package com.component.account.system.util;

import java.util.UUID;

/**
 * 类备注：
 *
 * @author Administrator
 * @version 1.0
 * @date 2018-01-10 17:34
 * @desc
 * @since 1.8
 */
public class SystemUtil {

    public static String generateUuid() {

        return UUID.randomUUID().toString();
    }
}
