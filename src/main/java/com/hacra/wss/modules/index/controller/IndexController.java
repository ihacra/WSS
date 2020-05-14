package com.hacra.wss.modules.index.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hacra.wss.modules.index.service.IndexService;
import com.hacra.wss.modules.sys.entity.User;
import com.hacra.wss.modules.sys.service.UserService;

/**
 * IndexController
 * 
 * @author Hacra
 * @date 2020/05/11
 */
@Controller
@RequestMapping("/")
public class IndexController {

	@Autowired
	private IndexService indexService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/")
	public String index(Model model) {
		User user = userService.get("1");
		model.addAttribute("user", user);
		return "modules/index/index";
	}
}
