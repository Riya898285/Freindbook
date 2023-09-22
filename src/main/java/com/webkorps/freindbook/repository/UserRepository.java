package com.webkorps.freindbook.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.webkorps.freindbook.Entity.*;


//Riya
public interface UserRepository extends JpaRepository<User,Integer>{

	public User findByUsername(String username);
	public User findByEmail(String email);
	
	
    User findByEmailAndPassword(String email,String password);
	
	
	public User findById(int id);
	
	@Query(value = "select * from user u where u.username like %:username% ", nativeQuery = true)
	public List<User> searchByUsername(@Param("username") String username);
	
	
	
	
}




















































































//@Query(value = "select * from user u where u.username like %:username% ", nativeQuery = true)
