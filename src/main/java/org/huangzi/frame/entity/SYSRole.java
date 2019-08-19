package org.huangzi.frame.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.sql.Timestamp;

/**
 * @author: XGLLHZ
 * @date: 2019/8/19 23:21
 * @description: 系统-角色表
 */
@Data
@Accessors(chain = true)
@TableName("sys_role")
public class SYSRole {

    @TableId(type = IdType.AUTO)
    private Integer id;   //角色主键

    private String roleNamey;   //英文名

    private String roleNamez;   //中文名

    private Integer deleteFlag;   //删除状态：0：未删除；1：已删除

    private Timestamp createdTime;   //创建时间

    private Timestamp updateTime;   //修改时间

}
