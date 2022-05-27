package com.zhang.system.repository;

import com.zhang.system.info.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 负责数据查询的接口
 * @author xiaomi
 * @date 2022/5/24
 */
@Repository
public interface UserRepository extends JpaRepository<UserInfo,Long> {


}
