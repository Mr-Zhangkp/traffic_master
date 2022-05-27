package com.zhang.api.code;

/**
 * 系统管理模块(traffic-system)的错误码
 * 区间: 10000-15555
 * @author xiaomi
 * @date 2022/5/24
 */
public interface SystemCode {


    /**
     * 系统通用的成功状态码
     */
    String TRAFFIC_SYSTEM_SUCCESS = "000000";

    /**
     * 系统通用的错误状态码
     */
    String TRAFFIC_SYSTEM_ERROR = "999999";


    //错误 ERROR 提示 INFO 警告 WARN

    /**
     * 用户管理  10000-10999
     */

    //10000-10499 错误提示
    String SYSTEM_USER_ERROR_ADD_FAIL = "10000";
    String SYSTEM_USER_ERROR_ADD_FAIL_PARAM_NULL = "10001";
    String SYSTEM_USER_ERROR_ADD_FAIL_NAME_NULL = "10002";
    String SYSTEM_USER_ERROR_ADD_FAIL_ACCOUNT_NULL = "10003";
    String SYSTEM_USER_ERROR_ADD_FAIL_PASS_NULL = "10004";
    String SYSTEM_USER_ERROR_ADD_FAIL_PHONE_NULL = "10005";
    String SYSTEM_USER_ERROR_ADD_FAIL_NAME_LENGTH = "10006";
    String SYSTEM_USER_ERROR_ADD_FAIL_ACCOUNT_SIZE = "10007";
    String SYSTEM_USER_ERROR_ADD_FAIL_PASS_SIZE = "10008";
    String SYSTEM_USER_ERROR_DEL_FAIL_UID_NULL = "10009";
    //10500-10999 成功提示
    int SYSTEM_USER_INFO_ADD_ = 10500;


    /**
     * 角色管理  11000-11999
     */

    int SYSTEM_ROLE_ERROR_ADD_FAIL = 11000;

    /**
     * 权限管理   12000-12999
     */
}
