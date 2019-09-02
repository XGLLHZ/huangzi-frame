package org.huangzi.frame.controller;

import org.huangzi.frame.entity.SYSRole;
import org.huangzi.frame.service.SYSRoleService;
import org.huangzi.frame.util.APIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: XGLLHZ
 * @date: 2019/8/20 15:37
 * @description: 系统-角色前端控制器
 */
@RestController
@RequestMapping("/admin/role")
public class SYSRoleController {

    @Autowired
    SYSRoleService sysRoleService;

    /**
     * 获取数据列表
     * @param sysRole
     * @return
     */
    @RequestMapping("/list")
    public APIResponse list(@RequestBody SYSRole sysRole) {
        return sysRoleService.list(sysRole);
    }

    /**
     * 获取详情
     * @param sysRole
     * @return
     */
    @RequestMapping("/get")
    public APIResponse get(@RequestBody SYSRole sysRole) {
        return sysRoleService.get(sysRole);
    }

    /**
     * 新增
     * @param sysRole
     * @return
     */
    @RequestMapping("/insert")
    public APIResponse insert(@RequestBody SYSRole sysRole) {
        return sysRoleService.list(sysRole);
    }

    /**
     * 删除
     * @param sysRole
     * @return
     */
    @RequestMapping("/delete")
    public APIResponse delete(@RequestBody SYSRole sysRole) {
        return sysRoleService.delete(sysRole);
    }

    /**
     * 修改
     * @param sysRole
     * @return
     */
    @RequestMapping("/update")
    public APIResponse update(SYSRole sysRole) {
        return sysRoleService.update(sysRole);
    }

}
