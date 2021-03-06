package com.hacra.wss.modules.sys.service;

import org.springframework.stereotype.Service;

import com.hacra.wss.common.base.BaseCrudService;
import com.hacra.wss.modules.sys.dao.UserDao;
import com.hacra.wss.modules.sys.entity.User;

/**
 * UserService
 * 
 * @author Hacra
 * @date 2020/05/11
 */
@Service
public class UserService extends BaseCrudService<UserDao, User>{

}
