package org.huangzi.frame.service;

import org.huangzi.frame.entity.SYSPermission;
import org.huangzi.frame.util.APIResponse;

/**
 * @author: XGLLHZ
 * @date: 2019/8/20 11:38
 * @description: 系统-权限事务层
 */
public interface SYSPermService {

    /**
     * 获取数据列表
     * @param sysPermission
     * @return
     */
    APIResponse list(SYSPermission sysPermission);

}
