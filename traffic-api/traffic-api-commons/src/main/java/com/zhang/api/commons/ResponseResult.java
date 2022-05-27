package com.zhang.api.commons;

/**
 * 每次都返回这个类的对象给前端,把查询到的结果封装到result中
 * @author xiaomi
 * @date 2022/5/24
 */
public class ResponseResult<T> {

    /**
     * 响应状态码
     */
    String resultCode;

    /**
     * 响应信息(错误的时候会写上)
     */
    String resultMsg;

    /**
     * 具体响应结果
     */
    T result;

    public ResponseResult(String resultCode) {
        this.resultCode = resultCode;
    }

    public ResponseResult(String resultCode, String resultMsg) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
    }

    public ResponseResult(String resultCode, String resultMsg, T result) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
        this.result = result;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
