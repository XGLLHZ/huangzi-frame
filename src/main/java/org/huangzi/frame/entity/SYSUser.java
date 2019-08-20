package org.huangzi.frame.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;
import org.huangzi.frame.util.BaseEntityUtil;

import java.sql.Timestamp;

/**
 * @author: XGLLHZ
 * @date: 2019/8/19 23:04
 * @description: 系统-用户表
 */
@Data
@Accessors(chain = true)
@TableName("sys_user")
public class SYSUser extends BaseEntityUtil {

    @TableId(type = IdType.AUTO)
    private Integer id;   //主键

    private String userAccount;   //账号

    private String userPass;   //密码

    private Integer deleteFlag;   //删除状态：0：未删除；1：已删除

    private Timestamp createdTime;   //创建时间

    private Timestamp updateTime;   //修改时间

}
