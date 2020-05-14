package com.hacra.wss.modules.index.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * IndexController
 * 
 * @author Hacra
 * @date 2020/05/11
 */
@Controller
@RequestMapping("/")
public class IndexController {
	
	@RequestMapping("")
	public String index(Model model) {
		return "modules/index/index";
	}
}
