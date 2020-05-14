package com.hacra.wss.common.util;

import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * SessionUtils
 * 
 * @author Hacra
 * @date 2020/05/13
 */
public class SessionUtils {

	private static HttpSession session = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getSession();
	
	public static final String USER_ID = "uID";
	
	/**
	 * 获取当前登录人id
	 * @return
	 */
	public static String getLoginUserId() {
		return session == null ? null : (String)session.getAttribute(USER_ID);
	}
	
	/**
	 * 设置当前登录人id
	 * @param user_id
	 */
	public static void setLoginUserId(String userId) {
		session.setAttribute(USER_ID, userId);
	}
}
