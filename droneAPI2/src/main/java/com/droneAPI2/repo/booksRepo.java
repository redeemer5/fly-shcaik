package com.droneAPI2.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.droneAPI2.models.books;

@Repository
public interface booksRepo extends JpaRepository<books,Integer> {
	
	
		List<books> findByField(String field);
		
		List<books> findBybooktitle(String booktitle);
		
		List<books> findBylibrary (String library);
	  

}
