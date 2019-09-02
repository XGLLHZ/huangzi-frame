package org.huangzi.frame.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.huangzi.frame.config.ConstConfig;
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
public class SYSPermServiceImpl extends ServiceImpl<SYSPermMapper, SYSPermission> implements SYSPermService {

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

    @Override
    public APIResponse get(SYSPermission sysPermission) {
        SYSPermission sysPermission1 = sysPermMapper.selectById(sysPermission.getId());
        Map<String, Object> data = new HashMap<>();
        data.put("dataInfo", sysPermission1);
        return new APIResponse(data);
    }

    @Override
    public APIResponse insert(SYSPermission sysPermission) {
        SYSPermission sysPermission1 = sysPermMapper.getByUrl(sysPermission.getPermUrl());
        if (sysPermission1 != null) {
            return new APIResponse(ConstConfig.RE_ALREADY_EXIST_ERROR_CODE, ConstConfig.RE_ALREADY_EXIST_ERROR_MESSAGE);
        } else {
            sysPermMapper.insert(sysPermission);
            return new APIResponse();
        }
    }

    @Override
    public APIResponse delete(SYSPermission sysPermission) {
        SYSPermission sysPermission1 = sysPermMapper.selectById(sysPermission.getId());
        if (sysPermission1 != null) {
            sysPermission1.setDeleteFlag(ConstConfig.DELETE_FLAG_ONE);
            sysPermMapper.updateById(sysPermission1);
            return new APIResponse();
        } else {
            return new APIResponse(ConstConfig.RE_NO_EXIST_ERROR_CODE, ConstConfig.RE_NO_EXIST_ERROR_MESSAGE);
        }
    }

    @Override
    public APIResponse update(SYSPermission sysPermission) {
        SYSPermission sysPermission1 = sysPermMapper.selectById(sysPermission.getId());
        if (sysPermission1 != null) {
            sysPermMapper.updateById(sysPermission);
            return new APIResponse();
        }else {
            return new APIResponse(ConstConfig.RE_NO_EXIST_ERROR_CODE, ConstConfig.RE_NO_EXIST_ERROR_MESSAGE);
        }
    }

}

