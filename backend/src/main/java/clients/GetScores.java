package clients;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import common.LLatestScores;

public class GetScores {
    
    

public static void main(String[] args) {

        try {

           
            
            HttpHeaders httpHeaders = new HttpHeaders();                                                
            RestTemplate restTemplate = new RestTemplate();
            httpHeaders.setContentType(MediaType.APPLICATION_JSON);
                        
            String url = "http://localhost:8081/api/v1/getScores";    
                        
            ParameterizedTypeReference<List<LLatestScores>>  parameterizedTypeReference = new ParameterizedTypeReference<List<LLatestScores>>(){};                
            ResponseEntity<List<LLatestScores>> res = restTemplate.exchange(url, HttpMethod.POST, null,parameterizedTypeReference);
                                 
            
            List<LLatestScores> scoresList = res.getBody();         
           
                                    
            for (int i=0;i<scoresList.size(); i++)
            {
                LLatestScores latesScores = scoresList.get(i);
                System.out.println(latesScores.getId()+","+latesScores.getUsername()+","+latesScores.getHiraganaScore1()+","+latesScores.getHiraganaScore2()+","+latesScores.getHiraganaScore2()+","+latesScores.getKatakanaScore1()+","+latesScores.getKatakanaScore2()+","+latesScores.getKatakanaScore3());
            }
                                    
                                                
        } catch (Exception e) {
            System.out.println("***** WYSTĄPIŁ BŁĄD *****");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }    
    
   
}