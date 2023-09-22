package com.webkorps.freindbook.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.webkorps.freindbook.Entity.Followers;

public interface FollowerRepository extends JpaRepository<Followers,Integer>{
	
	@Query(value="select * from followers where user_id =:user_id ", nativeQuery =true)
	public List<Followers> findByUserId(@Param("user_id") int user_id);
}
