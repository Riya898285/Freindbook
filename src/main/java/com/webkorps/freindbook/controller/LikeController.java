package com.webkorps.freindbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.webkorps.freindbook.Entity.Like;
import com.webkorps.freindbook.servicesImpl.LikeServiceImpl;

@Controller
public class LikeController {

	
	@Autowired
	private LikeServiceImpl likeservice;
	
	@PostMapping("/home/like")
	public String likepost(Like l) {
		likeservice.likeAdd(l);
		return "redirect:/users/home";
	}


}
