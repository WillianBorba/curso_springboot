package com.borba.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.borba.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
}
