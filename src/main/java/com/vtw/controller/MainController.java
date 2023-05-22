package com.vtw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping
	public String index() throws Exception {
		return "main/index";
	}
	
	@GetMapping("oracle")
	public String oracle() throws Exception {
		
		return "main/oracle";
	}
}
