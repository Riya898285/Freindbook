package com.webkorps.freindbook.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.webkorps.freindbook.Entity.Followers;
import com.webkorps.freindbook.repository.FollowerRepository;
import com.webkorps.freindbook.service.FollowerService;


@Service
public class FollowerServicesImpl implements FollowerService{

	@Autowired
	private FollowerRepository folloRepo;


	
	public Followers addtoFollower(Followers follower)
	{
		folloRepo.save(follower);
		return follower;
	}
	public List<Followers> showFollowers(int userid)
	{
		
		List<Followers> list=folloRepo.findByUserId(userid);
		return list;
	}
	
	
}
