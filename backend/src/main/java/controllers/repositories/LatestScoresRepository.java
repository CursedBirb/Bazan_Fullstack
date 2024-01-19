package controllers.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import controllers.models.LatestScores;

@Repository
public interface LatestScoresRepository extends JpaRepository<LatestScores, Integer>{

    public LatestScores findById(int id);
    public LatestScores findByUsername(String username);
    
}