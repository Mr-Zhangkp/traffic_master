package com.zhang.system.service;

import com.zhang.api.commons.SystemUtils;
import com.zhang.system.entity.UserEntity;
import com.zhang.system.info.UserInfo;
import com.zhang.system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xiaomi
 * @date 2022/5/24
 */
public interface UserService {

    boolean addUser(UserEntity userEntity);

    boolean delUser(String uid);
}
