package org.huangzi.frame.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.huangzi.frame.entity.SYSRole;

import java.util.List;

/**
 * @author: XGLLHZ
 * @date: 2019/8/20 10:14
 * @description: 系统-角色表mapper接口
 */
public interface SYSRoleMapper extends BaseMapper<SYSRole> {

    /**
     * 获取数据列表
     * @param page
     * @param condition
     * @return
     */
    List<SYSRole> list(Page<SYSRole> page, @Param("condition") SYSRole condition);

    /**
     * 获取数据总数
     * @return
     */
    Integer total();

    /**
     * 根据角色英文名获取详情
     * @param roleNamey
     * @return
     */
    SYSRole getByRoleNamey(@Param("condition") String roleNamey);

}
