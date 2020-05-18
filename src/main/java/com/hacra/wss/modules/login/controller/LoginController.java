package com.hacra.wss.modules.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hacra.wss.common.base.BaseController;
import com.hacra.wss.common.util.StringUtils;
import com.hacra.wss.modules.login.service.LoginService;
import com.hacra.wss.modules.sys.entity.User;
import com.hacra.wss.modules.sys.util.UserUtils;

/**
 * LoginController
 * 
 * @author Hacra
 * @version 2020/05/12
 */
@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {

	@Autowired
	private LoginService loginService;
	
	@ModelAttribute
	public User get(@RequestParam(required=false) String id) {
		User entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = UserUtils.getUserById(id);
		}
		if (entity == null){
			entity = new User();
		}
		return entity;
	}
	
	/**
	 * 登录页面
	 * @param model
	 * @return
	 */
	@RequestMapping("")
	public String index(User user, Model model) {
		return "modules/login/login";
	}
	
	/**
	 * 用户登录
	 * @return
	 */
	@RequestMapping("login")
	public String login(User user, RedirectAttributes redirectAttributes) {
		int flag = loginService.login(user);
		switch (flag) {
		case 0: 
			addAttribute(redirectAttributes, "user", user);
			return "redirect:/";
		case 1: 
			addMessage(redirectAttributes, "用户名错误！");
			return "redirect:/login";
		case 2:
			addMessage(redirectAttributes, "密码错误！");
			return "redirect:/login";
		default:
			addMessage(redirectAttributes, "登录异常！");
			return "redirect:/login";
		}
	}
	
	/**
	 * 用户注册
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping("register")
	public String register(User user, RedirectAttributes redirectAttributes) {
		int flag = loginService.register(user);
		switch (flag) {
		case 0: 
			addAttribute(redirectAttributes, "user", user);
			addMessage(redirectAttributes, "注册成功！");
			return "redirect:/";
		case 1:
			addMessage(redirectAttributes, "用户名重复！");
			return "redirect:/login?register";
		default:
			addMessage(redirectAttributes, "注册异常！");
			return "redirect:/login?register";
		}
	}
}
