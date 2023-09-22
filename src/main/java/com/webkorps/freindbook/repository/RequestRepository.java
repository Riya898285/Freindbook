package com.webkorps.freindbook.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.webkorps.freindbook.Entity.Request;
import com.webkorps.freindbook.Entity.User;



public interface RequestRepository extends JpaRepository<Request,Integer>
{

	@Query(value = " select * from request where recieverid =:recieverid and acceptid =:acceptid", nativeQuery = true)
	public List<Request> findByReciverId(@Param("recieverid")int reciverid,@Param("acceptid") int acceptid);
	@Modifying
	@Query(value = "update request set acceptid = 1 where id =:id", nativeQuery = true)
	public void acceptRequest(@Param("id") int id);

}
