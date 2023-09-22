package com.webkorps.freindbook.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webkorps.freindbook.Entity.Like;
import com.webkorps.freindbook.repository.LikeRepository;
import com.webkorps.freindbook.service.LikeService;

@Service
public class LikeServiceImpl implements LikeService{

	@Autowired
	private LikeRepository likeRepo;

	@Override
	public Like likeAdd(Like likes) {
		likeRepo.save(likes);
		return likes;
	}

	@Override
	public List<Like> getAllLikes(int postId) {
		return this.likeRepo.findBypostId(postId);
	}
	
}
