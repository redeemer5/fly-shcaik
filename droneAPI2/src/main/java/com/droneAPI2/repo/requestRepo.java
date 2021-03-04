package com.droneAPI2.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.droneAPI2.models.requestModel;

@Repository
public interface requestRepo extends JpaRepository<requestModel,Integer> {
	
	List<requestModel> findByLibrary(String library);
	
	List<requestModel> findByEmail(String email);
	
}
