package com.hacra.wss.modules.index.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hacra.wss.common.base.BaseController;
import com.hacra.wss.common.util.StringUtils;
import com.hacra.wss.modules.sys.entity.User;
import com.hacra.wss.modules.sys.util.UserUtils;

/**
 * IndexController
 * 
 * @author Hacra
 * @date 2020/05/11
 */
@Controller
@RequestMapping({"index", ""})
public class IndexController extends BaseController {
	
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
	 * 首页
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping("")
	public String index(User user, Model model) {
		return "modules/index/index";
	}
}
