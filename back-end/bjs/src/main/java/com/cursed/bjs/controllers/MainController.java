package com.cursed.bjs.controllers;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;

import com.cursed.bjs.models.Hiragana;
import com.cursed.bjs.models.Katakana;
import com.cursed.bjs.models.LatestScores;

import com.cursed.bjs.repositories.HiraganaRepository;
import com.cursed.bjs.repositories.KatakanaRepository;
import com.cursed.bjs.repositories.LatestScoresRepository;

import com.cursed.bjs.controllers.LLatestScores;

import jakarta.servlet.ServletRequest;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class MainController {

    @Autowired private HiraganaRepository hRepository;
    @Autowired private KatakanaRepository kRepository;
    @Autowired private LatestScoresRepository lSRepository;

    @GetMapping("/getData")
    @ResponseBody
    public String sayHello() {
        return "Hello from Spring Boot!";
    }

    @PostMapping("/sendData")
    public String receiveData(@RequestBody String data) {
       System.out.println("Received data: " + data);
       return "Data received: " + data;
    }

    @RequestMapping(value = "/addScore", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> addTransfer(@RequestBody String jsonString)    {

        try {

            
            
            JSONObject obj = new JSONObject(jsonString);
            String username = obj.getString("username");
            String hiragana_score_1 = obj.getString("hiragana_score_1");
            String hiragana_score_2 = obj.getString("hiragana_score_2");
            String hiragana_score_3 = obj.getString("hiragana_score_3");
            String katakana_score_1 = obj.getString("katakana_score_1");
            String katakana_score_2 = obj.getString("katakana_score_2");
            String katakana_score_3 = obj.getString("katakana_score_3");

            LatestScores latestScores = new LatestScores(username, Long.parseLong(hiragana_score_1), Long.parseLong(hiragana_score_2), Long.parseLong(hiragana_score_3), Long.parseLong(katakana_score_1), Long.parseLong(katakana_score_2), Long.parseLong(katakana_score_3));

            lSRepository.save(latestScores);

            ResponseEntity<String> res = new ResponseEntity("Dodano nowe wyniki", HttpStatus.OK);
            return res;

        } catch (Exception e) {
            String text = new String("ERROR:"+e.getMessage());
            ResponseEntity<String> res = new ResponseEntity(text, HttpStatus.OK);
            return res;
        }

    }

    @RequestMapping(value = "/getScores", method = RequestMethod.POST)
    public ResponseEntity<ArrayList<LLatestScores>> getLatest(ServletRequest request) {
              
        try
        {                                    
                
            //List<Transfer> transferList = transferRepository.findByUsername(userName);
            List<LatestScores> latestScoresList = lSRepository.findAll();

            if (latestScoresList==null) 
            {           
                throw new IllegalArgumentException("Nie ma danych");                             
            }

            ArrayList<LLatestScores> locLatestList = new ArrayList<LLatestScores>();

            for (int i=0; i<latestScoresList.size(); i++)
            {
                LatestScores latest = latestScoresList.get(i);
                LLatestScores locLatest = new LLatestScores(latest);
                locLatestList.add(locLatest);                  
            }

            System.out.println("Data send: " + locLatestList);
            
            ResponseEntity<ArrayList<LLatestScores>> res = new ResponseEntity(locLatestList, HttpStatus.OK);
            return res;

        }        
        catch (Exception e)
        {         
            ArrayList<LLatestScores> locLatestList = new ArrayList<LLatestScores>();            
            LLatestScores locLatest = new LLatestScores();
            locLatest.setUsername("ERROR:"+e.getMessage());
            locLatestList.add(locLatest);
            ResponseEntity<ArrayList<LLatestScores>> res = new ResponseEntity(locLatestList, HttpStatus.OK);
            return res;
        }
    }

   
    

    @ExceptionHandler
    public String handlerException(Model model,Exception exception)
    {
        String message = exception.getMessage();
        model.addAttribute("errormessage", message);
        return "errorpage";
    }
    
}
