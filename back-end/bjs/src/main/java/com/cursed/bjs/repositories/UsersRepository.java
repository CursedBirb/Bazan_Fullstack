package com.cursed.bjs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursed.bjs.models.Users;

public interface UsersRepository extends JpaRepository<Users, Long>{
    
}
