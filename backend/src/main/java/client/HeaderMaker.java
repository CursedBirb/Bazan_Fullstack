package client;

import java.util.Arrays;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

public class HeaderMaker {
    
    
    //Przygotowanie nagłówka z nazwą uzytkownika i haslem
    public static HttpHeaders getHeaders(String user,String password)
    {
        String adminuserCredentials = user+":"+password;
        String encodedCredentials =
                new String(Base64.encodeBase64(adminuserCredentials.getBytes()));
        
        System.out.println("Basic " + encodedCredentials+"|");
                

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", "Basic " + encodedCredentials);
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        return httpHeaders;
    }


}

