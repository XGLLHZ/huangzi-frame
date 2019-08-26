package org.huangzi.frame.controller;

import org.huangzi.frame.config.ConstConfig;
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

    /**
     * 获取数据列表
     * @param sysUser
     * @return
     */
    @RequestMapping("/list")
    public APIResponse list(@RequestBody SYSUser sysUser) {
        return sysUserService.list(sysUser);
    }

    /**
     * 详情
     * @param sysUser
     * @return
     */
    @RequestMapping("/get")
    public APIResponse get(@RequestBody SYSUser sysUser) {
        return sysUserService.get(sysUser);
    }

    /**
     * 用户-新增-注册
     * @param sysUser
     * @return
     */
    @RequestMapping("/register")
    public APIResponse insert(@RequestBody SYSUser sysUser) {
        return sysUserService.insert(sysUser);
    }

    /**
     * 用户-登录
     * @param sysUser
     * @return
     */
    @RequestMapping("/login")
    public APIResponse login(@RequestBody SYSUser sysUser) {
        return sysUserService.login(sysUser);
    }

    /**
     * spring security 返回登录提示
     * @return
     */
    @RequestMapping("/login_code")
    public APIResponse loginCode() {
        return new APIResponse(ConstConfig.RE_PLEASE_LOGIN_FIRST_CODE, ConstConfig.RE_PLEASE_LOGIN_FIRST_MESSAGE);
    }

    /**
     * 删除
     * @param sysUser
     * @return
     */
    @RequestMapping("/delete")
    public APIResponse delete(@RequestBody SYSUser sysUser) {
        return sysUserService.delete(sysUser);
    }

    /**
     * 修改
     * @param sysUser
     * @return
     */
    @RequestMapping("/update")
    public APIResponse update(@RequestBody SYSUser sysUser) {
        return sysUserService.update(sysUser);
    }

    /**
     * 给用户绑定角色
     * @param userId 用户id
     * @param roleIds 角色id数组
     * @return
     */
    @RequestMapping("/userBindRole")
    public APIResponse userBindRole(int userId, int[] roleIds) {
        return sysUserService.userBindRole(userId, roleIds);
    }

}
