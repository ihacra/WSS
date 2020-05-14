package com.hacra.wss.modules.index.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hacra.wss.common.util.SessionUtils;
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
		model.addAttribute("id1", SessionUtils.getLoginUserId());
		SessionUtils.setLoginUserId("1234");
		model.addAttribute("id2", SessionUtils.getLoginUserId());
		return "modules/index/index";
	}
}
