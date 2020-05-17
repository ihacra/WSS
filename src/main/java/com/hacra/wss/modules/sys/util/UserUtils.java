package com.hacra.wss.modules.sys.util;

import com.hacra.wss.common.util.EhCacheUtils;
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
	public static final String USER_CACHE_LN_ = "LN_";
	
	/**
	 * 根据ID获取用户
	 * @param id
	 * @return 取不到返回null
	 */
	public static User getUserById(String id){
		User user = (User)EhCacheUtils.get(USER_CACHE, USER_CACHE_ID_ + id + "_" + DateUtils.getDate());
		if (user ==  null){
			user = userDao.get(id);
			if (user == null){
				return null;
			}
			EhCacheUtils.put(USER_CACHE, USER_CACHE_ID_ + user.getId() + "_" +DateUtils.getDate(), user);
		}
		return user;
	}
	
	/**
	 * 根据LoginName获取用户
	 * @param loginName
	 * @return 取不到返回null
	 */
	public static User getUserByLoginName(String loginName){
		User user = (User)EhCacheUtils.get(USER_CACHE, USER_CACHE_LN_ + loginName + "_" + DateUtils.getDate());
		if (user ==  null){
			user = userDao.get(new User(null, loginName));
			if (user == null){
				return null;
			}
			EhCacheUtils.put(USER_CACHE, USER_CACHE_LN_ + user.getId() + "_" +DateUtils.getDate(), user);
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
			user = getUserById(loginUserId);
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
