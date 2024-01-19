package client;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import utils.MY_GLOBAL;

public class TestDeleteTransfer {
    
      
    
    public static void main(String[] args) {

        
        try {           
            
            HttpHeaders httpHeaders = new HttpHeaders();                                                
            RestTemplate restTemplate = new RestTemplate();
            httpHeaders.setContentType(MediaType.APPLICATION_JSON);
                       
            
            String url = MY_GLOBAL.adress+"/deletetransfer";    
            
            String jsonString = "{'transferidtodelete':'3'}";
                                    
            HttpEntity<String> entity = new HttpEntity<String>(jsonString,httpHeaders);            
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);  
            
            String result = response.getBody();
                        
            System.out.println(result);       
                        
                                                
        } catch (Exception e) {
            System.out.println("***** WYSTĄPIŁ BŁĄD *****");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
         
