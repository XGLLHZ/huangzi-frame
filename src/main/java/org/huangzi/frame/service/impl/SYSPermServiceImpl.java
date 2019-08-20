package org.huangzi.frame.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.huangzi.frame.entity.SYSPermission;
import org.huangzi.frame.mapper.SYSPermMapper;
import org.huangzi.frame.service.SYSPermService;
import org.huangzi.frame.util.APIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: XGLLHZ
 * @date: 2019/8/20 15:33
 * @description:
 */
@Service
public class SYSPermServiceImpl implements SYSPermService {

    @Autowired
    SYSPermMapper sysPermMapper;

    @Override
    public APIResponse list(SYSPermission sysPermission) {
        Page<SYSPermission> page = new Page<>(sysPermission.getCurrentPage(), sysPermission.getPageSize());
        List<SYSPermission> list = sysPermMapper.list(page, sysPermission);
        Integer total = sysPermMapper.total();
        Map<String, Object> data = new HashMap<>();
        data.put("dataList", list);
        data.put("total", total);
        return new APIResponse(data);
    }

}

