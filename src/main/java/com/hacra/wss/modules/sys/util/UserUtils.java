package com.hacra.wss.modules.sys.util;

import com.hacra.wss.common.util.CacheUtils;
import com.hacra.wss.common.util.DateUtils;
import com.hacra.wss.common.util.SessionUtils;
import com.hacra.wss.common.util.SpringContextHolder;
import com.hacra.wss.common.util.StringUtils;
import com.hacra.wss.modules.sys.dao.UserDao;
import com.hacra.wss.modules.sys.entity.User;

/**
 * UserUtils
 * 
 * @author Hacra
 * @date 2020/05/13
 */
public class UserUtils {

	private static UserDao userDao = SpringContextHolder.getBean(UserDao.class);

	public static final String USER_CACHE = "userCache";
	public static final String USER_CACHE_ID_ = "ID_";
	
	/**
	 * 根据ID获取用户
	 * @param id
	 * @return 取不到返回null
	 */
	public static User get(String id){
		User user = (User)CacheUtils.get(USER_CACHE, USER_CACHE_ID_ + id + "_" + DateUtils.getDate());
		if (user ==  null){
			user = userDao.get(id);
			if (user == null){
				return null;
			}
			CacheUtils.put(USER_CACHE, USER_CACHE_ID_ + user.getId() + "_" +DateUtils.getDate(), user);
		}
		return user;
	}
	
	/**
	 * 获取当前登录人
	 * @return 取不到返回 new User()
	 */
	public static User getUser(){
		User user = null;
		String loginUserId = SessionUtils.getLoginUserId();
		if (StringUtils.isNotBlank(loginUserId)){
			user = get(loginUserId);
		}
		return user == null ? new User() : user;
	}
	
	/**
	 * 获取登录状态
	 * @return
	 */
	public static boolean getLoginStatus() {
		return StringUtils.isBlank(SessionUtils.getLoginUserId());
	}
}
