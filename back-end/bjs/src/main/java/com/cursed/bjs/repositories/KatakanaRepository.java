package com.cursed.bjs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursed.bjs.models.Katakana;

public interface KatakanaRepository extends JpaRepository<Katakana, Long>{
    
}
