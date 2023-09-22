package com.webkorps.freindbook.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.webkorps.freindbook.Entity.Coment;

public interface CommentRepository extends JpaRepository<Coment,Integer>{

	@Query(value = "select * from comment c  where c.post_id = :post_id", nativeQuery = true)
	public List<Coment> findByPostId(@Param("post_id") int post_id);
	
}
