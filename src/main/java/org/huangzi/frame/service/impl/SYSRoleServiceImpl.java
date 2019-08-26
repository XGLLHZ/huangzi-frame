package org.huangzi.frame.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.huangzi.frame.config.ConstConfig;
import org.huangzi.frame.entity.SYSPermRole;
import org.huangzi.frame.entity.SYSRole;
import org.huangzi.frame.mapper.SYSPermRoleMapper;
import org.huangzi.frame.mapper.SYSRoleMapper;
import org.huangzi.frame.service.SYSRoleService;
import org.huangzi.frame.util.APIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: XGLLHZ
 * @date: 2019/8/20 15:19
 * @description:
 */
@Service
public class SYSRoleServiceImpl implements SYSRoleService {

    @Autowired
    SYSRoleMapper sysRoleMapper;

    @Autowired
    SYSPermRoleMapper sysPermRoleMapper;

    @Override
    public APIResponse list(SYSRole sysRole) {
        Page<SYSRole> page = new Page<>(sysRole.getCurrentPage(), sysRole.getPageSize());
        List<SYSRole> list = sysRoleMapper.list(page, sysRole);
        Integer total = sysRoleMapper.total();
        Map<String, Object> data = new HashMap<>();
        data.put("dataList", list);
        data.put("total", total);
        return new APIResponse(data);
    }

    @Override
    public APIResponse get(SYSRole sysRole) {
        SYSRole sysRole1 = sysRoleMapper.selectById(sysRole.getId());
        if (sysRole1 != null) {
            Map<String, Object> data = new HashMap<>();
            data.put("info", sysRole1);
            return new APIResponse(data);
        } else {
            return new APIResponse(ConstConfig.RE_NO_EXIST_ERROR_CODE, ConstConfig.RE_NO_EXIST_ERROR_MESSAGE);
        }
    }

    @Override
    public APIResponse insert(SYSRole sysRole) {
        SYSRole sysRole1 = sysRoleMapper.getByRoleNamey(sysRole.getRoleNamey());
        if (sysRole1 != null) {
            return new APIResponse(ConstConfig.RE_ALREADY_EXIST_ERROR_CODE, ConstConfig.RE_ALREADY_EXIST_ERROR_MESSAGE);
        } else {
            sysRoleMapper.insert(sysRole);
            return new APIResponse();
        }
    }

    @Override
    public APIResponse delete(SYSRole sysRole) {
        SYSRole sysRole1 = sysRoleMapper.selectById(sysRole.getId());
        if (sysRole1 != null) {
            sysRoleMapper.deleteById(sysRole.getId());
            return new APIResponse();
        } else {
            return new APIResponse(ConstConfig.RE_NO_EXIST_ERROR_CODE, ConstConfig.RE_NO_EXIST_ERROR_MESSAGE);
        }
    }

    @Override
    public APIResponse update(SYSRole sysRole) {
        SYSRole sysRole1 = sysRoleMapper.selectById(sysRole.getId());
        if (sysRole1 != null) {
            sysRoleMapper.updateById(sysRole);
            return new APIResponse();
        } else {
            return new APIResponse(ConstConfig.RE_NO_EXIST_ERROR_CODE, ConstConfig.RE_NO_EXIST_ERROR_MESSAGE);
        }
    }

    @Override
    public APIResponse insertRolePerm(int roleId, int[] permIds) {
        List<SYSPermRole> list = new ArrayList<>();
        for (int permId : permIds) {
            SYSPermRole sysPermRole = new SYSPermRole();
            sysPermRole.setRoleId(roleId);
            sysPermRole.setPermId(permId);
        }
        //在这里批量插入，方法还为完成
        return null;
    }

}
