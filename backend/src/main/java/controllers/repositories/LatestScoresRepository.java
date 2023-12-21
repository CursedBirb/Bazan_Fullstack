package controllers.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import controllers.models.LatestScores;

public interface LatestScoresRepository extends JpaRepository<LatestScores, Long>{

    public LatestScores findById(int id);
    
}