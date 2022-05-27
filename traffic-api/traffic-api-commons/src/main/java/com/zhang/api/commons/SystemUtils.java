package com.zhang.api.commons;

/**
 * 判断对象是否为null
 * @author xiaomi
 * @date 2022/5/25
 */
public class SystemUtils {
    /**
     * 判断对象是否为null
     * @param object
     * @return
     */
    public static boolean isNull(Object object){
        return null == object;
    }

    public static boolean isNullOrEmpty(String str){
        //为什么去空格,因为如果str是"  ",调用equals方法是不等于""的,但是这是可以任务str是"",所有需要去掉空格
        //也就是说equals不认为"  "和""是相等的,但我们任务他们是相等的
        return null == str || str.trim().equals("");
    }
}
