package controllers.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import controllers.models.Users;

public interface UsersRepository extends JpaRepository<Users, Long>{
    
}
