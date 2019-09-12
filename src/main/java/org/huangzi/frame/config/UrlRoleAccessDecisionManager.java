package org.huangzi.frame.config;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Iterator;

/**
 * @author: XGLLHZ
 * @date: 2019/8/22 22:33
 * @description: 权限决策：
 */
@Component
public class UrlRoleAccessDecisionManager implements AccessDecisionManager {

    /**
     * 根据用户账号所具有的角色与请求该地址所需要的角色对比，判断用户是否有权限
     * @param authentication 用户所具有的角色列表
     * @param o
     * @param collection 请求该资源（地址/权限）所需要的角色列表
     * @throws AccessDeniedException
     * @throws InsufficientAuthenticationException
     */
    @Override
    public void decide(Authentication authentication, Object o, Collection<ConfigAttribute> collection)
            throws AccessDeniedException, InsufficientAuthenticationException {
        Iterator<ConfigAttribute> iterator = collection.iterator();
        while (iterator.hasNext()) {
            ConfigAttribute configuration = iterator.next();
            String requestRole = configuration.getAttribute();
            //如果角色为 LOGIN_ROLE ，则说明当前的请求不需要任何角色，所以直接放过
            if ("LOGIN_ROLE".equals(requestRole)) {
                System.out.println("也是放行");
                return;
            }
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            for (GrantedAuthority authority : authorities) {
                if (authority.getAuthority().equals(requestRole)) {
                    return;
                }
            }
        }
        throw new AccessDeniedException("权限不足！");
    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return false;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }

}
