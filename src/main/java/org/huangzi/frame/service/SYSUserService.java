package org.huangzi.frame.service;

import org.huangzi.frame.entity.SYSUser;
import org.huangzi.frame.util.APIResponse;

/**
 * @author: XGLLHZ
 * @date: 2019/8/20 11:34
 * @description: 系统-用户事务层
 */
public interface SYSUserService {

    /**
     * 获取数据列表
     * @param sysUser
     * @return
     */
    APIResponse list(SYSUser sysUser);

}
