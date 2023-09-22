package com.webkorps.freindbook.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.webkorps.freindbook.Entity.Following;
import com.webkorps.freindbook.repository.FollowingRepository;
import com.webkorps.freindbook.service.FollowingService;

@Service
public class FollowingServiceImpl implements FollowingService {

	@Autowired
	private FollowingRepository followingRepo;

	/*public FollowingRepository getFollowingRepo() {
		return followingRepo;
	}

	public void setFollowingRepo(FollowingRepository followingRepo) {
		this.followingRepo = followingRepo;
	}
	*/
	public Following addtoFollowingList(Following follow)
	{
		followingRepo.save(follow); 
		return follow;
	}
	public List<Following> showFolowings(int userId) {
	    List<Following> followingList = followingRepo.findByUserId(userId);
	    return followingList;
	}

	
}
