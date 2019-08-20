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

    @RequestMapping("/list")
    public APIResponse list(@RequestBody SYSRole sysRole) {
        return sysRoleService.list(sysRole);
    }

}
