package org.huangzi.frame.service;

import org.huangzi.frame.entity.SYSRole;
import org.huangzi.frame.util.APIResponse;

/**
 * @author: XGLLHZ
 * @date: 2019/8/20 11:37
 * @description: 系统-角色事务层
 */
public interface SYSRoleService {

    /**
     * 获取数据列表
     * @param sysRole
     * @return
     */
    APIResponse list(SYSRole sysRole);

}
