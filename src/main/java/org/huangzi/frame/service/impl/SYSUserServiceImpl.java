package org.huangzi.frame.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.huangzi.frame.config.ConstConfig;
import org.huangzi.frame.entity.SYSRole;
import org.huangzi.frame.entity.SYSToken;
import org.huangzi.frame.entity.SYSUser;
import org.huangzi.frame.entity.SYSUserRole;
import org.huangzi.frame.mapper.SYSTokenMapper;
import org.huangzi.frame.mapper.SYSUserMapper;
import org.huangzi.frame.mapper.SYSUserRoleMapper;
import org.huangzi.frame.service.SYSUserRoleService;
import org.huangzi.frame.service.SYSUserService;
import org.huangzi.frame.util.APIResponse;
import org.huangzi.frame.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: XGLLHZ
 * @date: 2019/8/20 11:40
 * @description: 系统-用户-事务层实现类
 */
@Service
public class SYSUserServiceImpl extends ServiceImpl<SYSUserMapper, SYSUser> implements SYSUserService {

    @Autowired
    SYSUserMapper sysUserMapper;

    @Autowired
    SYSUserRoleMapper sysUserRoleMapper;

    @Autowired
    SYSTokenMapper sysTokenMapper;

    SYSUserRoleService sysUserRoleService;

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
    public APIResponse get(SYSUser sysUser) {
        SYSUser sysUser1 = sysUserMapper.selectById(sysUser.getId());
        if (sysUser1 != null) {
            Map<String, Object> data = new HashMap<>();
            List<SYSRole> list = sysUserMapper.userRoleList(sysUser.getId());
            data.put("dataInfo", sysUser1);
            data.put("dataList", list);
            return new APIResponse(data);
        } else {
            return new APIResponse(ConstConfig.RE_NO_EXIST_ERROR_CODE, ConstConfig.RE_NO_EXIST_ERROR_MESSAGE);
        }
    }

    @Override
    public APIResponse insert(SYSUser sysUser) {
        SYSUser sysUser1 = sysUserMapper.selectOne(
                new QueryWrapper<SYSUser>().eq("user_account", sysUser.getUserAccount()));
        if (sysUser1 != null) {
            return new APIResponse(ConstConfig.RE_NAME_ALREADY_EXIST_ERROR_CODE,
                    ConstConfig.RE_NAME_ALREADY_EXIST_ERROR_MESSAGE);
        } else {
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            String password = bCryptPasswordEncoder.encode(sysUser.getUserPass());
            sysUser.setUserPass(password);
            sysUserMapper.insert(sysUser);
            List<SYSUserRole> list = new ArrayList<>();
            if (sysUser.getRoleIds() != null && sysUser.getRoleIds().length > 0) {
                for (int roleId : sysUser.getRoleIds()) {
                    SYSUserRole sysUserRole = new SYSUserRole();
                    sysUserRole.setUserId(sysUser.getId());
                    sysUserRole.setRoleId(roleId);
                    list.add(sysUserRole);
                }
                boolean res = sysUserRoleService.saveBatch(list);
                if (res) {
                    return new APIResponse();
                } else {
                    return new APIResponse(ConstConfig.RE_ERROR_CODE, ConstConfig.RE_ERROR_MESSAGE);
                }
            }
            return new APIResponse();
        }
    }

    @Override
    public APIResponse login(SYSUser sysUser) {
        SYSUser sysUser1 = sysUserMapper.selectOne(
                new QueryWrapper<SYSUser>().eq("user_account", sysUser.getUserAccount()));
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        boolean checkPass = bCryptPasswordEncoder.matches(sysUser.getUserPass(), sysUser1.getPassword());
        if (sysUser1 != null && checkPass) {

            //登录判断成功时 创建或者修改token
            String token = TokenUtil.createJWS(String.valueOf(sysUser1.getId()));
            SYSToken sysToken = sysTokenMapper.selectOne(
                    new QueryWrapper<SYSToken>().eq("user_id", sysUser1.getId()));
            if (sysToken != null) {   //若此用户有过登录历史，则为其更新token
                sysToken.setToken(token);
                sysTokenMapper.updateById(sysToken);
            } else {   //若无登录历史，则为其创建token
                sysToken.setToken(token);
                sysTokenMapper.insert(sysToken);
            }

            Map<String, Object> data = new HashMap<>();
            sysUser1.setUserPass("");
            data.put("dataInfo", sysUser1);
            data.put("token", token);
            return new APIResponse(data);
        } else {
            return new APIResponse(ConstConfig.RE_USERNAME_USERPWD_ERROR_CODE, ConstConfig.RE_USERNAME_USERPWD_ERROR_MESSAGE);
        }
    }

    @Override
    public APIResponse delete(SYSUser sysUser) {
        SYSUser sysUser1 = sysUserMapper.selectById(sysUser.getId());
        if (sysUser1 != null) {
            sysUser1.setDeleteFlag(ConstConfig.DELETE_FLAG_ONE);
            sysUserMapper.updateById(sysUser1);
            List<SYSUserRole> list = sysUserRoleMapper.selectList(
                    new QueryWrapper<SYSUserRole>().eq("user_id", sysUser.getId()));
            if (list != null && list.size() > 0) {
                for (SYSUserRole sysUserRole : list) {
                    sysUserRole.setDeleteFlag(ConstConfig.DELETE_FLAG_ONE);
                }
                boolean res = sysUserRoleService.updateBatchById(list);
                if (res) {
                    return new APIResponse();
                } else {
                    return new APIResponse(ConstConfig.RE_ERROR_CODE, ConstConfig.RE_ERROR_MESSAGE);
                }
            }
            return new APIResponse();
        } else {
            return new APIResponse(ConstConfig.RE_NO_EXIST_ERROR_CODE, ConstConfig.RE_NO_EXIST_ERROR_MESSAGE);
        }
    }

    @Override
    public APIResponse update(SYSUser sysUser) {
        SYSUser sysUser1 = sysUserMapper.selectById(sysUser.getId());
        if (sysUser1 != null) {
            sysUserMapper.updateById(sysUser);
            return new APIResponse();
        } else {
            return new APIResponse(ConstConfig.RE_NO_EXIST_ERROR_CODE, ConstConfig.RE_NO_EXIST_ERROR_MESSAGE);
        }
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        SYSUser sysUser = sysUserMapper.selectOne(
                new QueryWrapper<SYSUser>().eq("user_account", userName));
        if (sysUser != null) {
            List<SYSRole> list = sysUserMapper.userRoleList(sysUser.getId());
            sysUser.setList(list);
        } else {
            throw new UsernameNotFoundException("用户名不存在！");
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
