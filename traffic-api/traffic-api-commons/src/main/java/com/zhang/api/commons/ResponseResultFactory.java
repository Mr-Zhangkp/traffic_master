package com.zhang.api.commons;

import com.zhang.api.code.SystemCode;

/**
 * @author xiaomi
 * @date 2022/5/25
 */
public class ResponseResultFactory<T> {

    /**
     * 构建一个通用的成功的返回结果
     * @return
     */
    public static ResponseResult buildResponseResult(){
        return new ResponseResult(SystemCode.TRAFFIC_SYSTEM_SUCCESS);
    }
    public static ResponseResult buildResponseResult(String resultCode){
        return new ResponseResult(resultCode);
    }
    public static ResponseResult buildResponseResult(String resultCode, String resultMsg){
        return new ResponseResult(resultCode,resultMsg);
    }
    public static <T> ResponseResult buildResponseResult(String resultCode, String resultMsg, T result){
        return new ResponseResult(resultCode,resultMsg,result);
    }

}
