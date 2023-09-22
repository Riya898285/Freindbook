package com.webkorps.freindbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.webkorps.freindbook.Entity.Coment;
import com.webkorps.freindbook.servicesImpl.CommentServiceImpl;

@Controller
public class CommentController {

	@Autowired 
	private CommentServiceImpl commentserv;
	
	@PostMapping("/home/comment")
	public String addComment(Coment com)
	{
		commentserv.addComment(com);
		return "redirect:/users/home";
		
	}
	
}
