package com.zxx.websocket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/public/*")
public class WelcomeController {
	@RequestMapping(value="index.html")
	public String welcome(){
		return "index";
	}
}
