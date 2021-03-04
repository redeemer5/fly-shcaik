package com.droneAPI2.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.droneAPI2.models.library;
import com.droneAPI2.models.users;



@Repository
public interface libRepo extends JpaRepository<library,Integer> {
	
	List<library> findByLibraryAndPassword(String library,String password);

}
