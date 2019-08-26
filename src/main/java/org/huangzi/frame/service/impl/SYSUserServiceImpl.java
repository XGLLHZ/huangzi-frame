package org.huangzi.frame.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.huangzi.frame.config.ConstConfig;
import org.huangzi.frame.entity.SYSRole;
import org.huangzi.frame.entity.SYSUser;
import org.huangzi.frame.mapper.SYSUserMapper;
import org.huangzi.frame.service.SYSUserService;
import org.huangzi.frame.util.APIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: XGLLHZ
 * @date: 2019/8/20 11:40
 * @description: 系统-用户-事务层实现类
 */
@Service
public class SYSUserServiceImpl implements SYSUserService {

    @Autowired
    SYSUserMapper sysUserMapper;

    @Override
    public APIResponse list(SYSUser sysUser) {
        Page<SYSUser> page = new Page<>(sysUser.getCurrentPage(), sysUser.getPageSize());
        List<SYSUser> list = sysUserMapper.list(page, sysUser);
        Integer total = sysUserMapper.total();
        Map<String, Object> data = new HashMap<>();
        data.put("dataList", list);
        data.put("total", total);
        return new APIResponse(data);
    }

    @Override
    public APIResponse insert(SYSUser sysUser) {
        SYSUser sysUser1 = sysUserMapper.getUserByName(sysUser.getUserAccount());
        if (sysUser1 != null) {
            return new APIResponse(ConstConfig.RE_NAME_ALREADY_EXIST_ERROR_CODE,
                    ConstConfig.RE_NAME_ALREADY_EXIST_ERROR_MESSAGE);
        } else {
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            String password = bCryptPasswordEncoder.encode(sysUser.getUserPass());
            sysUser.setUserPass(password);
            sysUserMapper.insert(sysUser);
            return new APIResponse();
        }
    }

    @Override
    public APIResponse login(SYSUser sysUser) {
        SYSUser sysUser1 = sysUserMapper.getUserByName(sysUser.getUserAccount());
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        boolean checkPass = bCryptPasswordEncoder.matches(sysUser.getUserPass(), sysUser1.getPassword());
        if (sysUser1 != null && checkPass) {
            Map<String, Object> data = new HashMap<>();
            data.put("id", sysUser1.getId());
            data.put("userAccount", sysUser1.getUserAccount());
            return new APIResponse(data);
        } else {
            return new APIResponse(ConstConfig.RE_USERNAME_USERPWD_ERROR_CODE, ConstConfig.RE_USERNAME_USERPWD_ERROR_MESSAGE);
        }
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        SYSUser sysUser = sysUserMapper.getUserByName(userName);
        if (sysUser == null) {
            throw new UsernameNotFoundException("用户名不存在！");
        } else {
            List<SYSRole> list = sysUserMapper.userRoleList(sysUser.getId());
            sysUser.setList(list);
        }
        return sysUser;
    }

    /**
     * 系统-用户-新增：密码加密、解密测试
     * @param args
     */
    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String rawPass = "123456";
        String password = bCryptPasswordEncoder.encode(rawPass);
        System.out.println("### " + password + " ###");
        boolean result = bCryptPasswordEncoder.matches(rawPass, password);
        System.out.println(result);
    }

}
