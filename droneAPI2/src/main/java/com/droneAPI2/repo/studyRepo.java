package com.droneAPI2.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.droneAPI2.models.study_field;

public interface studyRepo extends JpaRepository<study_field,Integer> {

}
