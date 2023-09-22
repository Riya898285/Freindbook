package com.webkorps.freindbook.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.webkorps.freindbook.Entity.Like;


public interface LikeRepository extends JpaRepository<Like,Integer>{

	@Query(value = "select * from likesssss l where l.post_id = :post_id", nativeQuery = true)
	public List<Like> findBypostId(@Param("post_id") int post_id);
	
	
}
