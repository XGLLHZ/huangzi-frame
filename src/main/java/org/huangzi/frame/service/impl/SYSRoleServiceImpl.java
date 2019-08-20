package org.huangzi.frame.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.huangzi.frame.entity.SYSRole;
import org.huangzi.frame.mapper.SYSRoleMapper;
import org.huangzi.frame.service.SYSRoleService;
import org.huangzi.frame.util.APIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
