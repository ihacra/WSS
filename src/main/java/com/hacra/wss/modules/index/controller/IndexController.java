package com.hacra.wss.modules.index.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hacra.wss.modules.index.service.IndexService;

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
	
	@RequestMapping("/")
	public String index() {
		return "modules/index/index";
	}
}
