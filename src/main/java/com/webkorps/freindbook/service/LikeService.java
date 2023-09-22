package com.webkorps.freindbook.service;

import java.util.List;

import com.webkorps.freindbook.Entity.Like;

public interface LikeService {

	public Like likeAdd(Like l);
	public List<Like> getAllLikes(int id);
	
}
