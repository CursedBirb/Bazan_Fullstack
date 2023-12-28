package controllers.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import controllers.models.Transfer;

@Repository
public interface TransferRepository extends JpaRepository<Transfer, Integer> {
    
        
    public Transfer findById(int id);
   

}

