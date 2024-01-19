package controllers.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import controllers.models.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long>{

    public Users findByUsername(String username);
    
}
