package com.webkorps.freindbook.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.webkorps.freindbook.Entity.Post;

public interface PostService {

	public boolean uploadPst(MultipartFile image, HttpSession session) throws IOException ;
	public List<Post> viewPost(int userid) ;
	public List<Post> viewPostofFollowing(int userid);
}
