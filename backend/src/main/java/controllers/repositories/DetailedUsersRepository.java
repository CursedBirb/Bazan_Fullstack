package controllers.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import controllers.models.DetailedUsers;

public interface DetailedUsersRepository extends JpaRepository<DetailedUsers, Long>{
    
}
