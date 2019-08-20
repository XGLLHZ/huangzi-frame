package org.huangzi.frame.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.huangzi.frame.entity.SYSUser;
import org.huangzi.frame.mapper.SYSUserMapper;
import org.huangzi.frame.service.SYSUserService;
import org.huangzi.frame.util.APIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: XGLLHZ
 * @date: 2019/8/20 11:40
 * @description:
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

}
