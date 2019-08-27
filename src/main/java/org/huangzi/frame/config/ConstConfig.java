package org.huangzi.frame.config;

/**
 * @author: XGLLHZ
 * @date: 2019/8/20 11:52
 * @description: 常量配置
 */
public class ConstConfig {

    /***************************基础请求************************************/

    //请求成功
    public static final Integer RE_SUCCESS_CODE = 200;
    public static final String RE_SUCCESS_MESSAGE = "请求成功！";

    //请求失败
    public static final Integer RE_ERROR_CODE = 201;
    public static final String RE_ERROR_MESSAGE = "请求失败！";

    /***************************登录、注册、注销相关*************************/

    //登录失败---用户名或密码错误
    public static final Integer RE_USERNAME_USERPWD_ERROR_CODE = 101;
    public static final String RE_USERNAME_USERPWD_ERROR_MESSAGE = "用户名或密码错误！";

    //登录失败---其它原因
    public static final Integer RE_LOGIN_ERROR_CODE = 102;
    public static final String RE_LOGIN_ERROR_MESSAGE = "登录失败！";

    //访问失败---权限不足
    public static final Integer RE_AUTHORITY_ERROR_CODE = 103;
    public static final String RE_AUTHORITY_ERROR_MESSAGE = "权限不足！";

    //注册失败-用户名已存在
    public static final Integer RE_NAME_ALREADY_EXIST_ERROR_CODE = 104;
    public static final String RE_NAME_ALREADY_EXIST_ERROR_MESSAGE = "用户名已存在！";

    //请先登录
    public static final Integer RE_PLEASE_LOGIN_FIRST_CODE = 105;
    public static final String RE_PLEASE_LOGIN_FIRST_MESSAGE = "请先登录！";

    /*****************************基础业务*******************************/

    //数据已存在
    public static final Integer RE_ALREADY_EXIST_ERROR_CODE = 110;
    public static final String RE_ALREADY_EXIST_ERROR_MESSAGE = "数据已存在！";

    //数据不存在
    public static final Integer RE_NO_EXIST_ERROR_CODE = 111;
    public static final String RE_NO_EXIST_ERROR_MESSAGE = "数据不存在！";

}
