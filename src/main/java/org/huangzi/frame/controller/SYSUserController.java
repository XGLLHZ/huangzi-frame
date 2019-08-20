package org.huangzi.frame.controller;

import org.huangzi.frame.entity.SYSUser;
import org.huangzi.frame.service.SYSUserService;
import org.huangzi.frame.util.APIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: XGLLHZ
 * @date: 2019/8/20 12:16
 * @description: 系统-用户前端控制器
 */
@RestController
@RequestMapping("/admin/user")
public class SYSUserController {

    @Autowired
    SYSUserService sysUserService;

    @RequestMapping("/list")
    public APIResponse list(@RequestBody SYSUser sysUser) {
        return sysUserService.list(sysUser);
    }

}
