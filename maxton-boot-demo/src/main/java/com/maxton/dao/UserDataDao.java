package com.maxton.dao;

import com.maxton.model.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Description
 * @Author maxton.zhang
 * @Date 2019/10/31 13:08
 * @Version 1.0
 */
public interface UserDataDao extends JpaRepository<UserData, String>, JpaSpecificationExecutor<UserData> {
}
