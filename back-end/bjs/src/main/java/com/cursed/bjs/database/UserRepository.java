package com.cursed.bjs.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Dodaj dodatkowe metody zapytań, jeśli są potrzebne
}
