package com.cursed.bjs.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HiraganaRepository extends JpaRepository<Hiragana, Integer> {
    // Dodaj dodatkowe metody zapytań, jeśli są potrzebne
}
