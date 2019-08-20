package org.huangzi.frame.controller;

import org.huangzi.frame.entity.SYSPermission;
import org.huangzi.frame.service.SYSPermService;
import org.huangzi.frame.util.APIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: XGLLHZ
 * @date: 2019/8/20 15:39
 * @description: 系统-权限前端控制器
 */
@RestController
@RequestMapping("/admin/permission")
public class SYSPermController {

    @Autowired
    SYSPermService sysPermService;

    @RequestMapping("/list")
    public APIResponse list(@RequestBody SYSPermission sysPermission) {
        return sysPermService.list(sysPermission);
    }

}
