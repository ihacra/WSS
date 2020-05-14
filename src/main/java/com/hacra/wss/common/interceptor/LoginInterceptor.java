package com.hacra.wss.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import com.hacra.wss.modules.sys.util.UserUtils;

/**
 * LoginInterceptor
 * 
 * @author Hacra
 * @version 2020/05/14
 */
public class LoginInterceptor implements HandlerInterceptor {

	/**
     * 在请求处理之前进行调用（Controller方法调用之前）
     */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		if (UserUtils.getLoginStatus()) {
			response.sendRedirect(request.getContextPath() + "/login");
			return false;
		} else {
			return true;
		}
	}
}
