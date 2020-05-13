package com.hacra.wss.modules.sys.dao;

import org.apache.ibatis.annotations.Mapper;

import com.hacra.wss.common.base.BaseCrudDao;
import com.hacra.wss.modules.sys.entity.User;

/**
 * UserDao
 * 
 * @author Hacra
 * @date 2020/05/13
 */
@Mapper
public interface UserDao extends BaseCrudDao<User> {

}
