package com.webkorps.freindbook.controller;

import java.io.IOException;

import javax.imageio.IIOException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.webkorps.freindbook.repository.PostRepository;
import com.webkorps.freindbook.servicesImpl.PostServiceImpl;



@Controller
public class PostController {
   
    
    @Autowired
    private PostServiceImpl postServiceImpl;

	
	
    @PostMapping("/post")
    public String uploadPost(@RequestParam("postpic") MultipartFile postpic,HttpSession session) throws IOException
    {
    	postServiceImpl.uploadPst(postpic, session);
    	return "redirect:/users/home";
    }
    
	
	
}
