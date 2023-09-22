package com.webkorps.freindbook.service;

import java.util.List;

import com.webkorps.freindbook.Entity.Following;
import com.webkorps.freindbook.repository.FollowingRepository;

public interface FollowingService {

	
	
	public Following addtoFollowingList(Following follow);
	public List<Following> showFolowings(int userId);
}
