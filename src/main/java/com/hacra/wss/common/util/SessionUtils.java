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

	public static final String USER_ID = "uID";
	
	/**
	 * 获取Session
	 * @return
	 */
	private static HttpSession getSession() {
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession();
	}
	
	/**
	 * 获取当前登录人id
	 * @param key
	 * @return
	 */
	public static String getLoginUserId() {
		return (String) getSession().getAttribute(USER_ID);
	}
	
	/**
	 * 设置当前登录人id
	 * @param key
	 */
	public static void setLoginUserId(String val) {
		getSession().setAttribute(USER_ID, val);
	}
}
