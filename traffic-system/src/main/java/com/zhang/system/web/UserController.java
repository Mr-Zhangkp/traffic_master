package com.zhang.system.web;

import com.zhang.api.code.SystemCode;
import com.zhang.api.commons.ResponseResult;
import com.zhang.api.commons.ResponseResultFactory;
import com.zhang.api.commons.SystemUtils;
import com.zhang.system.entity.UserEntity;
import com.zhang.system.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiaomi
 * @date 2022/5/24
 */
@RestController
@RequestMapping("/user")
public class UserController {


    /**
     * 我在哪个类中打印的日志
     */
    final Logger logger = LoggerFactory.getLogger(UserController.class);




    @Autowired
    UserService userService;

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public ResponseResult addUser(UserEntity userEntiry){
        ResponseResult responseResult = null;

        logger.info("system user addUser start");

        //参数为空
        if(SystemUtils.isNull(userEntiry)){

            logger.error("system user addUser UserEntity is null");

             responseResult =
                    ResponseResultFactory.buildResponseResult(SystemCode.
                            SYSTEM_USER_ERROR_ADD_FAIL_PARAM_NULL);

            logger.info("system user addUser return msg : " + responseResult);

            return responseResult;
        }

        //用户名为空
        if(SystemUtils.isNull(userEntiry.getUname())){

            logger.error("system user addUser uname is null");
            logger.info("param : " + userEntiry);

             responseResult =
                    ResponseResultFactory.buildResponseResult(SystemCode.
                            SYSTEM_USER_ERROR_ADD_FAIL_NAME_NULL);

            logger.info("system user addUser return msg : " + responseResult);

            return responseResult;
        }

        //账号为空
        if(SystemUtils.isNull(userEntiry.getUaccount())){
             responseResult =
                    ResponseResultFactory.buildResponseResult(SystemCode.
                            SYSTEM_USER_ERROR_ADD_FAIL_ACCOUNT_NULL);

            return responseResult;
        }

        //密码为空
        if(SystemUtils.isNull(userEntiry.getUpass())){
             responseResult =
                    ResponseResultFactory.buildResponseResult(SystemCode.
                            SYSTEM_USER_ERROR_ADD_FAIL_PASS_NULL);

            return responseResult;
        }

        //电话为空
        if(SystemUtils.isNull(userEntiry.getUphone())){
             responseResult =
                    ResponseResultFactory.buildResponseResult(SystemCode.
                            SYSTEM_USER_ERROR_ADD_FAIL_PHONE_NULL);

            return responseResult;
        }

        final int NAME_LENGTH = 3;
        //用户名长度小于3
        if(userEntiry.getUname().trim().length() < NAME_LENGTH){
             responseResult =
                    ResponseResultFactory.buildResponseResult(SystemCode.
                            SYSTEM_USER_ERROR_ADD_FAIL_NAME_LENGTH);

            return responseResult;
        }
        final int ACCOUNT_SIZE = 6;
        //用户名长度小于3
        if(userEntiry.getUname().trim().length() < ACCOUNT_SIZE){
             responseResult =
                    ResponseResultFactory.buildResponseResult(SystemCode.
                            SYSTEM_USER_ERROR_ADD_FAIL_ACCOUNT_SIZE);

            return responseResult;
        }
        final int PASS_SIZE = 6;
        //用户名长度小于3
        if(userEntiry.getUname().trim().length() < PASS_SIZE){
             responseResult =
                    ResponseResultFactory.buildResponseResult(SystemCode.
                            SYSTEM_USER_ERROR_ADD_FAIL_PASS_SIZE);

            return responseResult;
        }


        //保存用户信息
        boolean result = userService.addUser(userEntiry);

        //根据保存结果返回信息
        if(result){
            responseResult = ResponseResultFactory.buildResponseResult();
        }else{
            responseResult = ResponseResultFactory.buildResponseResult(SystemCode.SYSTEM_USER_ERROR_ADD_FAIL);
        }

        logger.info("system user addUser end , return : " + responseResult);

        return responseResult;

    }

    /**
     * 删除用户的请求
     * @param uid="1",删除一个; uid="1,2,3...",删除多个用','分割
     * @return
     */
    @RequestMapping(value = "/delUser",method = RequestMethod.POST)
    public ResponseResult delUser(String uid){

        if(SystemUtils.isNullOrEmpty(uid)){
            logger.error("system user delUser uid is null");

            ResponseResult responseResult =
                    ResponseResultFactory.buildResponseResult(SystemCode.
                            SYSTEM_USER_ERROR_DEL_FAIL_UID_NULL);

            logger.info("system user delUser return msg : " + responseResult);

            return responseResult;
        }

        ResponseResult responseResult = null;
        logger.info("system user delUser UserService start");
        //调用Service层
        boolean b = userService.delUser(uid);
        logger.info("system user delUser UserService end");

        //如果b是true, 表示删除成功
        if(b){
            //如果成功,打印日志
            logger.info("system user delUser success");
            responseResult = new ResponseResult(SystemCode.TRAFFIC_SYSTEM_SUCCESS);
        }else{
            //如果失败,打印日志
            logger.info("system user delUser fail");
            responseResult = new ResponseResult(SystemCode.TRAFFIC_SYSTEM_ERROR);
        }


        logger.info("system user delUser end");
        return responseResult;
    }
}
