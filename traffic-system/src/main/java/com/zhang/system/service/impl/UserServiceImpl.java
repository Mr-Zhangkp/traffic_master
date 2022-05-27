package com.zhang.system.service.impl;

import com.zhang.api.commons.SystemUtils;
import com.zhang.system.entity.UserEntity;
import com.zhang.system.info.UserInfo;
import com.zhang.system.repository.UserRepository;
import com.zhang.system.service.UserService;
import org.apache.catalina.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.zip.ZipEntry;

/**
 * @author xiaomi
 * @date 2022/5/24
 */

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    final int ZERO = 0;

    final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    /**
     * 添加用户
     * @param UserEntity
     * @return
     */
    @Override
    public boolean addUser(UserEntity UserEntity){

        UserInfo user = null;

        logger.info("system user addUser start : " + UserEntity);
        logger.info("system user addUser userRepository save start");

        try {
            user = userRepository.save(zhuanhuan(UserEntity));
        }catch (Exception e){
            logger.error("system user addUser fail" + e);
            return false;
        }

        logger.info("system user addUser userRepository save end");
        logger.info("user : " + user);

        if(!SystemUtils.isNull(user) && user.getUid() != ZERO){
            logger.info("system user addUser success");
            return true;
        }
        logger.error("system user addUser fail");
        return false;
    }

    /**
     * 删除用户
     * @param uid
     * @return
     */
    @Override
    public boolean delUser(String uid) {

        //接收数据分割为字符串数组
        String[] ids = uid.split(",");

        //校验
        if(SystemUtils.isNull(ids) || ids.length == 0){
            return false;
        }
        if(ids.length == 1){
            //删除一条

        }else {
            //删除多条

        }


        return false;
    }

    /**
     * 将UserEntity转成UserInfo
     * @param userEntity
     * @return
     */
    public UserInfo zhuanhuan(UserEntity userEntity){
        UserInfo userInfo = new UserInfo();

        userInfo.setDesc(userEntity.getDesc());
        userInfo.setT1(userEntity.getT1());
        userInfo.setUaccount(userEntity.getUaccount());
        userInfo.setUid(userEntity.getUid());
        userInfo.setUmail(userEntity.getUmail());
        userInfo.setUname(userEntity.getUname());
        userInfo.setUpass(userEntity.getUpass());
        userInfo.setUphone(userEntity.getUphone());


        System.out.println("hello");

        

        return userInfo;
    }
}
