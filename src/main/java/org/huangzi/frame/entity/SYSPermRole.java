package org.huangzi.frame.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.sql.Timestamp;

/**
 * @author: XGLLHZ
 * @date: 2019/8/19 23:35
 * @description: 系统-权限角色表
 */
@Data
@Accessors(chain = true)
@TableName("sys_perm_role")
public class SYSPermRole {

    @TableId(type = IdType.AUTO)
    private Integer id;   //主键

    private Integer permId;   //权限id

    private Integer roleId;   //角色id

    private Integer deleteFlag;   //删除状态：0：未删除；1：已删除

    private Timestamp createdTime;   //创建时间

    private Timestamp updateTime;   //修改时间

}
