package controllers.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import controllers.models.Roles;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Long> {
    
    public Roles findByRole(String role);
    
}

