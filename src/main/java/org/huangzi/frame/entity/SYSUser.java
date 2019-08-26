package org.huangzi.frame.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;
import org.huangzi.frame.util.BaseEntityUtil;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author: XGLLHZ
 * @date: 2019/8/19 23:04
 * @description: 系统-用户表
 */
@Data
@Accessors(chain = true)
@TableName("sys_user")
public class SYSUser extends BaseEntityUtil implements UserDetails {

    @TableId(type = IdType.AUTO)
    private Integer id;   //主键

    private String userAccount;   //账号

    private String userPass;   //密码

    private Integer deleteFlag;   //删除状态：0：未删除；1：已删除

    private Timestamp createdTime;   //创建时间

    private Timestamp updateTime;   //修改时间

    @TableField(exist = false)
    private List<SYSRole> list;   //用户所具有的角色

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (SYSRole role : list) {
            authorities.add(new SimpleGrantedAuthority(role.getRoleNamey()));
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return userPass;
    }

    @Override
    public String getUsername() {
        return userAccount;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
