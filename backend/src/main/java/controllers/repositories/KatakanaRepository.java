package controllers.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import controllers.models.Katakana;

public interface KatakanaRepository extends JpaRepository<Katakana, Long>{
    
}
