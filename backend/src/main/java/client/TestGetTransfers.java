package client;


import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import common.TTransfer;
import utils.MY_GLOBAL;

public class TestGetTransfers {

public static void main(String[] args) {

        try {
            
            HttpHeaders httpHeaders = new HttpHeaders();
            RestTemplate restTemplate = new RestTemplate();
            httpHeaders.setContentType(MediaType.APPLICATION_JSON);
                        
            String url = MY_GLOBAL.adress+"/gettransfers";
                        
            ParameterizedTypeReference<List<TTransfer>>  parameterizedTypeReference = new ParameterizedTypeReference<List<TTransfer>>(){};
            ResponseEntity<List<TTransfer>> res = restTemplate.exchange(url, HttpMethod.POST, null,parameterizedTypeReference);
            
            List<TTransfer> transferList = res.getBody();
                                    
            for (int i=0;i<transferList.size(); i++)
            {
                TTransfer transfer = transferList.get(i);
                System.out.println(transfer.getId()+","+transfer.getClientname()+","+transfer.getDate()+","+transfer.getDescription());
            }
                                    
        } catch (Exception e) {
            System.out.println("***** WYSTĄPIŁ BŁĄD *****");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    
}

