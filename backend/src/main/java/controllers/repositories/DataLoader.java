package controllers.repositories;

//Dodanie danych na samym poczatku

import controllers.models.Transfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


@Component
public class DataLoader implements ApplicationRunner {

   
    
    private TransferRepository transferRepository;
       
           
    @Autowired
    public DataLoader(TransferRepository transferRepository)
    {        
        this.transferRepository = transferRepository;
    }
    
    
    public void run(ApplicationArguments args) 
    {   
        try
        {            

            
            //Do aplikacji z przelewami
            Transfer trans1 = new Transfer("nowak","2022-10-22","Opłata za prąd",120.0);
            transferRepository.save(trans1);            
            
            Transfer trans2 = new Transfer("nowak","2022-10-22","Opłata za gaz",210.0);
            transferRepository.save(trans2);            
            
            Transfer trans3 = new Transfer("nowak","2022-10-20","Opłata za obiady",110.0);
            transferRepository.save(trans3);            
            
            Transfer trans4 = new Transfer("kowal","2022-10-24","Opłata za ochronę",90.0);
            transferRepository.save(trans4);            
            
            Transfer trans5 = new Transfer("kowal","2022-10-24","Opłata za mieszkanie",550.0);
            transferRepository.save(trans5);            
            
            
    
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
   
}



