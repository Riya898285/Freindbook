package com.webkorps.freindbook.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.webkorps.freindbook.Entity.Post;

public interface PostRepository extends JpaRepository<Post,Integer>{
	@Query(value = "select * from post where user_id =:user_id", nativeQuery = true)
	public List<Post> findbyUserid(@Param("user_id") int user_id);
	
	@Query(value = "select p.post_id , p.post_pic , p.user_id ,f.following_id from post p ,following f where p.user_id = f.following_id and f.user_id = :user_id", nativeQuery = true)
	public List<Post> findbyFollowerid(@Param("user_id") int user_id);
	
}
