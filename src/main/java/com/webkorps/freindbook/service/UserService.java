package com.webkorps.freindbook.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.webkorps.freindbook.Entity.User;

public interface UserService {

	public User creatUser(String name,String email, String password);
	public String generateUsername(String name);
	public User findUsername(String username);
	public User checkLogin(String email,String password);
	public User Update(String username,String favSong,String favPlace,String favbook);
	public User profileSave(User u, MultipartFile imageFile, String username) throws IOException ;
	public List<User> searchUser(@RequestParam("username") String user);
	public User getUser(String username);
}
