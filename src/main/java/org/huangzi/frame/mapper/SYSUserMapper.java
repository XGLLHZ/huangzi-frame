package org.huangzi.frame.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.huangzi.frame.entity.SYSUser;

import java.util.List;

/**
 * @author: XGLLHZ
 * @date: 2019/8/20 10:11
 * @description: 系统-用户表mapper接口
 */
public interface SYSUserMapper extends BaseMapper<SYSUser> {

    /**
     * 获取数据列表
     * @param page
     * @param condition
     * @return
     */
    List<SYSUser> list(Page<SYSUser> page, @Param("condition") SYSUser condition);

    /**
     * 获取数据总数
     * @return
     */
    Integer total();

    /**
     * 根据用户名获取用户信息
     * @param userAccount
     * @return
     */
    SYSUser getUserByName(@Param("condition") String userAccount);

}
