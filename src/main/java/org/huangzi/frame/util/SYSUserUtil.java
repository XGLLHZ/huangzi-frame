package org.huangzi.frame.util;

import org.huangzi.frame.entity.SYSUser;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author: XGLLHZ
 * @date: 2019/8/23 10:58
 * @description: 系统-用户工具类
 */
public class SYSUserUtil {

    /**
     * 获取系统当前登陆用户对应信息
     * @return
     */
    public static SYSUser getCurrentUser() {
        return (SYSUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

}
