package org.huangzi.frame.util;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author: XGLLHZ
 * @date: 2019/8/20 11:02
 * @description: 实体基础类
 */
@Data
@Accessors(chain = true)
public class BaseEntityUtil {

    @TableField(exist = false)
    private Integer currentPage = 1;   //分页参数：当前页，默认为1

    @TableField(exist = false)
    private Integer pageSize = 10;   //分页参数：页面大小，默认为10

    @TableField(exist = false)
    private String token;   //token

}
