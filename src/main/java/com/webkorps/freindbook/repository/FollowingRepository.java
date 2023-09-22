package com.webkorps.freindbook.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.webkorps.freindbook.Entity.Following;

public interface FollowingRepository extends JpaRepository<Following,Integer>{
	
	@Query(value = "SELECT * FROM following WHERE user_id = :userId", nativeQuery = true)
	public List<Following> findByUserId(@Param("userId") int userId);

}
