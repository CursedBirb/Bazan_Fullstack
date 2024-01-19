package controllers;


//To jest kontroler do przykładu z bankiem bez autoryzacji

import common.TTransfer;
import controllers.models.Transfer;
import controllers.repositories.TransferRepository;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletRequest;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


//To jest kontroler do częsci aplikacji bez JWT (baza danych osób)

//CORS (Cross-origin resource sharing) polega na tym, że domyślnie nie można w aplikacji pod danym adresem 
//wysłać zapytania do innej aplikacji sieciowej. 
//Mechanizm ten wprowadzono celem udaremnienia prób ataków na witryny internetowe typu Cross-site Request Forgery. 
//Atak ten polega na wysłaniu zapytania HTTP do innych serwisów wykorzystując uprawnienia użytkownika 
//np. stan zalogowania, inne dane zapisane w sesji lub w plikach cookie.

//Zabezpieczenie to jednak przeszkadza w testowaniu aplikacji
//Dlatego można je usunąć adnotacją: @CrossOrigin(maxAge = 3600) (3600 oznacza na jaki czas wyłączamy, tj. liczbę sekund wyłaczenia)


@CrossOrigin(maxAge = 3600)
@RestController
public class MyController {

    @Autowired
    TransferRepository transferRepository;

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public String systemInfo() {

        return "Testowy serwis webowy";
    }
    
            
    @RequestMapping(value = "/addtransfer", method = RequestMethod.POST)        
    public ResponseEntity<String> addTransfer(@RequestBody String jsonString)             
    {
                    
        try {

            
            
            JSONObject obj = new JSONObject(jsonString);
            String clientname = obj.getString("clientname");
            String date = obj.getString("date");
            String description = obj.getString("description");
            String amount = obj.getString("amount");
           
    
            Transfer transfer = new Transfer(clientname, date, description, Double.parseDouble(amount));

            transferRepository.save(transfer);

            ResponseEntity<String> res = new ResponseEntity("Dodano przelew", HttpStatus.OK);
            return res;

        } catch (Exception e) {
            String text = new String("ERROR:"+e.getMessage());
            ResponseEntity<String> res = new ResponseEntity(text, HttpStatus.OK);
            return res;
        }

    }

    
    @RequestMapping(value = "/gettransfers", method = RequestMethod.POST)
    public ResponseEntity<ArrayList<TTransfer>> getTransfers(ServletRequest request) {
              
        try
        {                                    
                
            //List<Transfer> transferList = transferRepository.findByUsername(userName);
            List<Transfer> transferList = transferRepository.findAll();

            if (transferList==null) 
            {           
                throw new IllegalArgumentException("Nie ma danych");                             
            }

            ArrayList<TTransfer> locTransferList = new ArrayList<TTransfer>();

            for (int i=0; i<transferList.size(); i++)
            {
                Transfer transfer = transferList.get(i);
                TTransfer locTransfer = new TTransfer(transfer);
                locTransferList.add(locTransfer);                  
            }

            ResponseEntity<ArrayList<TTransfer>> res = new ResponseEntity(locTransferList, HttpStatus.OK);
            return res;

        }        
        catch (Exception e)
        {         
            ArrayList<TTransfer> locTransferList = new ArrayList<TTransfer>();            
            TTransfer locTransfer = new TTransfer();
            locTransfer.setClientname("ERROR:"+e.getMessage());
            locTransferList.add(locTransfer);
            ResponseEntity<ArrayList<TTransfer>> res = new ResponseEntity(locTransferList, HttpStatus.OK);
            return res;
        }
    }

      
    
    @RequestMapping(value = "/deletetransfer", method = RequestMethod.POST)
    public ResponseEntity<String> deleteTransfer(@RequestBody String jsonString) {
     
        try {
            
            JSONObject obj = new JSONObject(jsonString);
            String transferidtodelete = obj.getString("transferidtodelete");
            int intTransferidtodelete = Integer.parseInt(transferidtodelete);
            
            
            Transfer locTransfer = transferRepository.findById(intTransferidtodelete);
            
            if (locTransfer == null) {
                throw new IllegalArgumentException("Nie ma w bazie przelewu o id: " + transferidtodelete);
            }

            transferRepository.delete(locTransfer);
            
            ResponseEntity<String> res = new ResponseEntity("Usunięto przelew o id: "+transferidtodelete, HttpStatus.OK);
            return res;
        } 
        catch (Exception e) {
            String text = new String(e.getMessage());            
            ResponseEntity<String> res = new ResponseEntity(text, HttpStatus.OK);
            return res;
        }
    }
    
    
}
