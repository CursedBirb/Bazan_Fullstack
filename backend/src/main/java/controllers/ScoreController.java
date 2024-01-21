package controllers;


import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import common.LLatestScores;
import controllers.models.LatestScores;
import controllers.repositories.LatestScoresRepository;
import services.AuthService;


//To jest kontroler do częsci aplikacji bez JWT (baza danych osób)

//CORS (Cross-origin resource sharing) polega na tym, że domyślnie nie można w aplikacji pod danym adresem
//wysłać zapytania do innej aplikacji sieciowej.
//Mechanizm ten wprowadzono celem udaremnienia prób ataków na witryny internetowe typu Cross-site Request Forgery.
//Atak ten polega na wysłaniu zapytania HTTP do innych serwisów wykorzystując uprawnienia użytkownika
//np. stan zalogowania, inne dane zapisane w sesji lub w plikach cookie.

//Zabezpieczenie to jednak przeszkadza w testowaniu aplikacji
//Dlatego można je usunąć adnotacją: @CrossOrigin(maxAge = 3600) (3600 oznacza na jaki czas wyłączamy, tj. liczbę sekund wyłaczenia)


// @CrossOrigin(allowCredentials = "true",
//             origins = "http://localhost:3000",
//             allowedHeaders = {"Authorization","Content-Type"},
//             maxAge = 3600,
//             exposedHeaders = {"Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"})
@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/api")
public class ScoreController {

    @Autowired
    LatestScoresRepository latestScoresRepository;

    private final AuthService authService;
    public ScoreController (AuthService authService) {

        this.authService = authService;
        
    }

    String username = "";
    
    @RequestMapping(value = "/getlatestscore", method = RequestMethod.POST)
    public ResponseEntity<ArrayList<LLatestScores>> getScores(@RequestBody String jsonString) {

        try {

            JSONObject obj = new JSONObject(jsonString);
            String username = obj.getString("username");
            String password = obj.getString("password");

            boolean isLoggedIn = authService.authService(username, password);

            if(!isLoggedIn) {

                ArrayList<LLatestScores> locLatestScoresList = new ArrayList<LLatestScores>();
                LLatestScores locScores = new LLatestScores();
                locScores.setUsername("ERROR:  Please log in first");
                locLatestScoresList.add(locScores);
                ResponseEntity<ArrayList<LLatestScores>> res = new ResponseEntity(locLatestScoresList, HttpStatus.OK);
                return res;

            }
                
            //List<Transfer> latestScoresList = latestScoresRepository.findByUsername(userName);
            List<LatestScores> latestScoresList = latestScoresRepository.findAll();

            if (latestScoresList==null) {

                throw new IllegalArgumentException("Nie ma danych");
            }


            ArrayList<LLatestScores> locLatestScoresList = new ArrayList<LLatestScores>();

            for (int i=0; i<latestScoresList.size(); i++) {

                LatestScores scores = latestScoresList.get(i);
                LLatestScores locScores = new LLatestScores(scores);
                locLatestScoresList.add(locScores);

            }

            ResponseEntity<ArrayList<LLatestScores>> res = new ResponseEntity(locLatestScoresList, HttpStatus.OK);
            return res;

        } catch (Exception e) {

            ArrayList<LLatestScores> locLatestScoresList = new ArrayList<LLatestScores>();
            LLatestScores locScores = new LLatestScores();
            locScores.setUsername("ERROR:"+e.getMessage());
            locLatestScoresList.add(locScores);
            ResponseEntity<ArrayList<LLatestScores>> res = new ResponseEntity(locLatestScoresList, HttpStatus.OK);
            return res;
        }
    }

    @RequestMapping(value = "/getscore", method = RequestMethod.POST)
    public ResponseEntity<LatestScores> getScore(@RequestBody String jsonString) {

        try {

            JSONObject obj = new JSONObject(jsonString);
            String username = obj.getString("username");
            String password = obj.getString("password");

            boolean isLoggedIn = authService.authService(username, password);

            if(!isLoggedIn) {

                LatestScores locScores = new LatestScores();
                locScores.setUsername("ERROR: Please log in first");
                ResponseEntity<LatestScores> res = new ResponseEntity(locScores, HttpStatus.OK);
                return res;

            }
                
            //List<Transfer> latestScoresList = latestScoresRepository.findByUsername(userName);
            LatestScores singleUserScore = latestScoresRepository.findByUsername(username);

            if (singleUserScore==null) {

                throw new IllegalArgumentException("Nie ma danych");
            }

            ResponseEntity<LatestScores> res = new ResponseEntity(singleUserScore, HttpStatus.OK);
            return res;

        } catch (Exception e) {

            LatestScores locScores = new LatestScores();
            locScores.setUsername("ERROR:"+e.getMessage()); 
            ResponseEntity<LatestScores> res = new ResponseEntity(locScores, HttpStatus.OK);
            return res;

        }
        
    }

    @RequestMapping(value = "/addhiraganascore", method = RequestMethod.POST)
    public ResponseEntity<String> addHiraganaScore(@RequestBody String jsonString)
    {
                    
        try {
            
            JSONObject obj = new JSONObject(jsonString);
            String username = obj.getString("username");
            String password = obj.getString("password");
            String hiraganaScore = obj.getString("hiraganaScore");

            boolean isLoggedIn = authService.authService(username, password);

            if(!isLoggedIn) {

                ResponseEntity<String> res = new ResponseEntity("ERROR: Please log in first", HttpStatus.OK);
                return res;

            }

            LatestScores existingRecord = latestScoresRepository.findByUsername(username);

            if(existingRecord != null) {

                long longExistingRecordH1 = existingRecord.getHiraganaScore1();
                long longExistingRecordH2 = existingRecord.getHiraganaScore2();
                long longExistingRecordH3 = existingRecord.getHiraganaScore3();


                if (!existingRecord.getHiraganaScore1().equals(-32L)) {

                    existingRecord.setHiraganaScore1(Long.parseLong(hiraganaScore));
                    
                }

                if (!existingRecord.getHiraganaScore2().equals(-32L) || longExistingRecordH1 > 0 ) {

                    existingRecord.setHiraganaScore2(Long.parseLong(hiraganaScore));
                    
                }

                if (!existingRecord.getHiraganaScore3().equals(-32L) || longExistingRecordH2 > 0 ) {

                    existingRecord.setHiraganaScore3(Long.parseLong(hiraganaScore));
                    
                }

                if (longExistingRecordH3 > 0) {

                    existingRecord.setHiraganaScore1(longExistingRecordH2);
                    existingRecord.setHiraganaScore2(longExistingRecordH3);
                    existingRecord.setHiraganaScore3(Long.parseLong(hiraganaScore));
                    
                }
                
                latestScoresRepository.save(existingRecord);

                ResponseEntity<String> res = new ResponseEntity("Dodano przelew", HttpStatus.OK);
                return res;

            } else {

                LatestScores latest = new LatestScores(username, Long.parseLong(hiraganaScore), -32L, -32L, -32L, -32L, -32L);

                latestScoresRepository.save(latest);

                ResponseEntity<String> res = new ResponseEntity("Dodano przelew", HttpStatus.OK);
                return res;

            }

            

        } catch (Exception e) {

            String text = new String("ERROR:"+e.getMessage());
            ResponseEntity<String> res = new ResponseEntity(text, HttpStatus.OK);
            return res;

        }

    }

    @RequestMapping(value = "/addkatakanascore", method = RequestMethod.POST)
    public ResponseEntity<String> addKatakanaScore(@RequestBody String jsonString)
    {
                    
        try {
            
            JSONObject obj = new JSONObject(jsonString);
            String username = obj.getString("username");
            String katakanaScore = obj.getString("katakanaScore");
            LatestScores existingRecord = latestScoresRepository.findByUsername(username);

            if(existingRecord != null) {

                long longExistingRecordK1 = existingRecord.getKatakanaScore1();
                long longExistingRecordK2 = existingRecord.getKatakanaScore2();
                long longExistingRecordK3 = existingRecord.getKatakanaScore3();

                if (!!existingRecord.getKatakanaScore1().equals(-32L)) {

                    existingRecord.setKatakanaScore1(Long.parseLong(katakanaScore));
                    
                }

                if (!existingRecord.getKatakanaScore2().equals(-32L) || longExistingRecordK1 > 0 ) {

                    existingRecord.setKatakanaScore2(Long.parseLong(katakanaScore));
                    
                }

                if (!existingRecord.getKatakanaScore3().equals(-32L) || longExistingRecordK2 > 0 ) {

                    existingRecord.setKatakanaScore3(Long.parseLong(katakanaScore));
                    
                }

                if (longExistingRecordK3 > 0) {

                    existingRecord.setKatakanaScore1(longExistingRecordK2);
                    existingRecord.setKatakanaScore2(longExistingRecordK3);
                    existingRecord.setKatakanaScore3(Long.parseLong(katakanaScore));
                    
                }
                
                latestScoresRepository.save(existingRecord);

                ResponseEntity<String> res = new ResponseEntity("Dodano przelew", HttpStatus.OK);
            return res;

            } else {

            LatestScores latest = new LatestScores(username, -32L, -32L, -32L, Long.parseLong(katakanaScore), -32L, -32L);

            latestScoresRepository.save(latest);

            ResponseEntity<String> res = new ResponseEntity("Dodano przelew", HttpStatus.OK);
            return res;

            }

            

        } catch (Exception e) {

            String text = new String("ERROR:"+e.getMessage());
            ResponseEntity<String> res = new ResponseEntity(text, HttpStatus.OK);
            return res;

        }

    }
    
}
