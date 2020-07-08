package com.lec.sts19_rest.myBoard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/myBoard")
public class MyBoardController {
	
	@RequestMapping(value = "/rest")
	public String rest() {
		return "index";
	}
	
}
