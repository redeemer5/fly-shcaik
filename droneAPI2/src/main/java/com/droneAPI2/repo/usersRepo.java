package com.droneAPI2.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.droneAPI2.models.users;

@Repository
public interface usersRepo extends JpaRepository<users,Integer> {
	
	List<users> findByEmailAndPassword(String email,String password);

}
