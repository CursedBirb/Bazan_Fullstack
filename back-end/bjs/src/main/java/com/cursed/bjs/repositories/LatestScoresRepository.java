package com.cursed.bjs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursed.bjs.models.LatestScores;

public interface LatestScoresRepository extends JpaRepository<LatestScores, Long>{

    public LatestScores findById(int id);
    
}