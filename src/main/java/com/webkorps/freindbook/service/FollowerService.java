package com.webkorps.freindbook.service;

import java.util.List;

import com.webkorps.freindbook.Entity.Followers;

public interface FollowerService {

	
	public Followers addtoFollower(Followers follower);
	public List<Followers> showFollowers(int userid);
}
