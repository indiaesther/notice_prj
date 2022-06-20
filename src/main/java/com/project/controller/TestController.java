package com.project.controller;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.mapper.TestMapper;

@MapperScan("com.project.mapper")
@Controller
@RequestMapping("/")
public class TestController {

	@Autowired
	TestMapper testMapper;

	@RequestMapping("/board")
	public String getRequest(@RequestParam(name = "greeting", required = false, defaultValue = "Esther") String greeting, Model model) {

		System.out.println("======================DB 연동확인=======================");
		System.out.println("   /borat 탔는지");
		System.out.println("   DB에서 가지고온 현재시간 : " + testMapper.getCurrentTime());

		model.addAttribute("greeting", greeting);
		model.addAttribute("testTime", testMapper.getCurrentTime());

		return "index";
	}

}
