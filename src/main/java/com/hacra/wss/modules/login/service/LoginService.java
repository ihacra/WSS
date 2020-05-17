package com.hacra.wss.modules.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hacra.wss.common.util.SessionUtils;
import com.hacra.wss.common.util.StringUtils;
import com.hacra.wss.modules.sys.entity.User;
import com.hacra.wss.modules.sys.service.UserService;
import com.hacra.wss.modules.sys.util.UserUtils;

/**
 * LoginService
 * 
 * @author Hacra
 * @version 2020/05/14
 */
@Service
public class LoginService {

	@Autowired
	private UserService userService;
	
	/**
	 * 登录方法
	 * 0： 登录成功
	 * 1: 用户名错误
	 * 2: 密码错误
	 * @param user
	 * @return
	 */
	public int login(User user) {
		User realUser = null;
		if (user != null && StringUtils.isNotBlank(user.getLoginName()) && StringUtils.isNotBlank(user.getPassword())) {
			realUser = UserUtils.getUserByLoginName(user.getLoginName());
		}
		if (realUser == null) {
			return 1;
		} else if (!user.getPassword().equals(realUser.getPassword())) {
			return 2;
		} else {
			user.setId(realUser.getId());
			SessionUtils.setLoginUserId(realUser.getId());
			return 0;
		}
	}
	
	/**
	 * 注册方法
	 * 0: 注册成功
	 * 1: 用户名重复
	 * @param user
	 * @return
	 */
	public int register(User user) {
		User realUser = null;
		if (user != null && StringUtils.isNotBlank(user.getLoginName()) && StringUtils.isNotBlank(user.getPassword())) {
			realUser = UserUtils.getUserByLoginName(user.getLoginName());
		}
		if (realUser != null) {
			return 1;
		} else {
			userService.save(user);
			SessionUtils.setLoginUserId(user.getId());
			return 0;
		}
	}
}
