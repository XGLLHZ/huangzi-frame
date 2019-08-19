package org.huangzi.frame.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.sql.Timestamp;

/**
 * @author: XGLLHZ
 * @date: 2019/8/19 23:27
 * @description: 系统-权限表
 */
@Data
@Accessors(chain = true)
@TableName("sys_permission")
public class SYSPermission {

    @TableId(type = IdType.AUTO)
    private Integer id;   //权限主键

    private Integer parentId;   //父菜单id

    private String permName;   //权限名称

    private String permUrl;   //权限url

    private Integer deleteFlag;   //删除状态：0：未删除；1：已删除

    private Timestamp createdTime;   //创建时间

    private Timestamp updateTime;   //修改时间

}
