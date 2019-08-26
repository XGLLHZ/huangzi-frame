package org.huangzi.frame.config;

import org.huangzi.frame.entity.SYSPermission;
import org.huangzi.frame.entity.SYSRole;
import org.huangzi.frame.mapper.SYSPermMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

/**
 * @author: XGLLHZ
 * @date: 2019/8/22 20:48
 * @description: 权限资源获取-拦截请求url，并根据url获取访问此资源所需的角色
 */
@Component
public class FilterRequestRole implements FilterInvocationSecurityMetadataSource {

    @Autowired
    SYSPermMapper sysPermMapper;

    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        String requestUrl = ((FilterInvocation) o).getRequestUrl();
        if ("/admin/user/login".equals(requestUrl)) {
            return null;
        }
        List<SYSPermission> list = sysPermMapper.allUrlRole();
        AntPathMatcher antPathMatcher = new AntPathMatcher();
        for (SYSPermission sysPermission : list) {
            if (antPathMatcher.match(sysPermission.getPermUrl(), requestUrl)) {
                List<SYSRole> sysPermissionList = sysPermission.getRoles();
                String[] roleArrays = new String[sysPermissionList.size()];
                for (int i = 0; i < sysPermissionList.size(); i++) {
                    roleArrays[i] = sysPermissionList.get(i).getRoleNamey();
                }
                return SecurityConfig.createList(roleArrays);
            }
        }
        return SecurityConfig.createList("LOGIN_ROLE");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }

}
