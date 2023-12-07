package com.cursed.bjs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursed.bjs.models.DetailedUsers;

public interface DetailedUsersRepository extends JpaRepository<DetailedUsers, Long>{
    
}
