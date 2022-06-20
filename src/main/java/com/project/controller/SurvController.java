package com.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class SurvController {

	@RequestMapping("/regSurv")
	public String regSurv() {
		return "RegSurv";
	}

}
