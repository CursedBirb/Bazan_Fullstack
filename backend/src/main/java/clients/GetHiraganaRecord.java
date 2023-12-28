package clients;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import common.HHiragana;

public class GetHiraganaRecord {

public static void main(String[] args) {

        try {

            HttpHeaders httpHeaders = new HttpHeaders();
            RestTemplate restTemplate = new RestTemplate();
            httpHeaders.setContentType(MediaType.APPLICATION_JSON);
                        
            String url = "http://localhost:8081/api/v1/gethiraganarecord";
                        
            ParameterizedTypeReference<List<HHiragana>>  parameterizedTypeReference = new ParameterizedTypeReference<List<HHiragana>>(){};
            ResponseEntity<List<HHiragana>> res = restTemplate.exchange(url, HttpMethod.POST, null,parameterizedTypeReference);

            List<HHiragana> hiraganaList = res.getBody();

            for (int i=0;i<hiraganaList.size(); i++)
            {
                HHiragana hiragana = hiraganaList.get(i);
                System.out.println(hiragana.getId()+","+hiragana.getHiraganaRomaji()+","+hiragana.getHiraganaRomaji());
            }
                                    
        } catch (Exception e) {
            System.out.println("***** WYSTĄPIŁ BŁĄD *****");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

}