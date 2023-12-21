package controllers.repositories;


import controllers.models.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferRepository extends JpaRepository<Transfer, Integer> {
    
        
    public Transfer findById(int id);
   

}

