package org.huangzi.frame.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.huangzi.frame.entity.SYSUser;
import org.huangzi.frame.service.SYSUserService;
import org.huangzi.frame.util.APIResponse;
import org.huangzi.frame.util.SYSUserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: XGLLHZ
 * @date: 2019/8/23 9:46
 * @description: spring security权限配置
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    SYSUserService sysUserService;  //系统用户信息-账号、角色

    @Autowired
    FilterRequestRole filterRequestRole;   //请求信息-url、角色

    @Autowired
    UrlRoleAccessDecisionManager urlRoleAccessDecisionManager;   //当前登录用户的角色与请求资源需要的角色对比

    @Autowired
    PermissionAccessDeniedHandler permissionAccessDeniedHandler;   //授权失败-权限不足

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(sysUserService)
                .passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    @Override
                    public <O extends FilterSecurityInterceptor> O postProcess(O o) {
                        o.setSecurityMetadataSource(filterRequestRole);
                        o.setAccessDecisionManager(urlRoleAccessDecisionManager);
                        return o;
                    }
                }).and().formLogin()/*
                .loginPage("/admin/user/login_code")
                .loginProcessingUrl("/admin/user/login")*/
                .usernameParameter("userAccount")
                .passwordParameter("userPass")
                .failureHandler(new AuthenticationFailureHandler() {
                    @Override
                    public void onAuthenticationFailure(HttpServletRequest request,
                                                        HttpServletResponse response,
                                                        AuthenticationException e) throws IOException, ServletException {
                        response.setContentType("application/json;charset=utf-8");
                        APIResponse apiResponse = new APIResponse();
                        if (e instanceof UsernameNotFoundException || e instanceof BadCredentialsException) {
                            apiResponse.setRecode(ConstConfig.RE_USERNAME_USERPWD_ERROR_CODE);
                            apiResponse.setRemsg(ConstConfig.RE_USERNAME_USERPWD_ERROR_MESSAGE);
                        } else {
                            apiResponse.setRecode(ConstConfig.RE_LOGIN_ERROR_CODE);
                            apiResponse.setRemsg(ConstConfig.RE_LOGIN_ERROR_MESSAGE);
                        }
                        ObjectMapper objectMapper = new ObjectMapper();
                        PrintWriter out = response.getWriter();
                        out.write(objectMapper.writeValueAsString(apiResponse));
                        out.flush();
                        out.close();
                    }
                })
                .successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest request,
                                                        HttpServletResponse response,
                                                        Authentication authentication) throws IOException, ServletException {
                        response.setContentType("application/json;charset=utf-8");
                        SYSUser sysUser = SYSUserUtil.getCurrentUser();
                        Map<String, Object> data = new HashMap<>();
                        data.put("id", sysUser.getId());
                        data.put("userAccount", sysUser.getUserAccount());
                        ObjectMapper objectMapper = new ObjectMapper();
                        PrintWriter out = response.getWriter();
                        out.write(objectMapper.writeValueAsString(new APIResponse(data)));
                        out.flush();
                        out.close();
                    }
                })
                .and()
                .logout()
                .permitAll()
                .and()
                .csrf()
                .disable()
                .exceptionHandling()
                .accessDeniedHandler(permissionAccessDeniedHandler);
    }

}
