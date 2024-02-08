package controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import common.HHiragana;
import controllers.models.Hiragana;
import controllers.repositories.HiraganaRepository;
import services.AuthService;

@CrossOrigin(maxAge = 3600)
// @CrossOrigin(allowCredentials = "true",
//             origins = "http://localhost:3000",
//             allowedHeaders = {"Authorization","Content-Type"},
//             maxAge = 3600,
//             exposedHeaders = {"Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"})
@RestController
@RequestMapping("/api")
public class HiraganaController {

    @Autowired
    HiraganaRepository hiraganaRepository;

    private final AuthService authService;
    public HiraganaController (AuthService authService) {

        this.authService = authService;

    }

    @RequestMapping(value = "/gethiraganarecord", method=RequestMethod.POST)
    public ResponseEntity<ArrayList<HHiragana>> getHiraganaRecords (@RequestBody String jsonString) {
        
        try {

            // JSONObject obj = new JSONObject(jsonString);
            // String username = obj.getString("username");
            // String password = obj.getString("password");

            // boolean isLoggedIn = authService.authService(username, password);

            // if(!isLoggedIn) {

            //     ArrayList<HHiragana> locHiraganaList = new ArrayList<HHiragana>();
            //     HHiragana locRecords = new HHiragana();
            //     locRecords.setHiraganaRomaji("ERROR: Please log in first");
            //     locHiraganaList.add(locRecords);
            //     ResponseEntity<ArrayList<HHiragana>> res = new ResponseEntity(locHiraganaList, HttpStatus.OK);
            //     return res;

            // }
                
            //List<Transfer> latestScoresList = latestScoresRepository.findByUsername(userName);
            List<Hiragana> hiraganaList = hiraganaRepository.findAll();

            if (hiraganaList==null)
            {
                throw new IllegalArgumentException("Nie ma danych");
            }

            ArrayList<HHiragana> locHiraganaList = new ArrayList<HHiragana>();

            for (int i=0; i<hiraganaList.size(); i++)
            {
                Hiragana records = hiraganaList.get(i);
                HHiragana locRecords = new HHiragana(records);
                locHiraganaList.add(locRecords);
            }

            ResponseEntity<ArrayList<HHiragana>> res = new ResponseEntity(locHiraganaList, HttpStatus.OK);
            return res;

        }
        catch (Exception e)
        {
            ArrayList<HHiragana> locHiraganaList = new ArrayList<HHiragana>();
            HHiragana locRecords = new HHiragana();
            locRecords.setHiraganaRomaji("ERROR:"+e.getMessage());
            locHiraganaList.add(locRecords);
            ResponseEntity<ArrayList<HHiragana>> res = new ResponseEntity(locHiraganaList, HttpStatus.OK);
            return res;
        }

    }
    

}
