package controllers;


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

import common.LLatestScores;
import controllers.models.LatestScores;
import controllers.repositories.LatestScoresRepository;


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
@RequestMapping("/api/v1")
public class ScoreController {

    @Autowired
    LatestScoresRepository latestScoresRepository;
    
    @RequestMapping(value = "/getlatestscore", method = RequestMethod.POST)
    public ResponseEntity<ArrayList<LLatestScores>> getScores(ServletRequest request) {

        try
        {
                
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

    @RequestMapping(value = "/addscore", method = RequestMethod.POST)
    public ResponseEntity<String> addScore(@RequestBody String jsonString)
    {
                    
        try {
            
            JSONObject obj = new JSONObject(jsonString);
            String username = obj.getString("username");
            String hiraganaScore = obj.getString("hiraganaScore");
            String katakanaScore = obj.getString("katakanaScore");
            LatestScores existingRecord = latestScoresRepository.findByUsername(username);

            if(existingRecord != null) {

                long longExistingRecordH1 = existingRecord.getHiraganaScore1();
                long longExistingRecordH2 = existingRecord.getHiraganaScore2();
                long longExistingRecordH3 = existingRecord.getHiraganaScore3();
                long longExistingRecordK1 = existingRecord.getKatakanaScore1();
                long longExistingRecordK2 = existingRecord.getKatakanaScore2();
                long longExistingRecordK3 = existingRecord.getKatakanaScore3();

                if (!!existingRecord.getHiraganaScore1().equals("-32")) {

                    existingRecord.setHiraganaScore1(Long.parseLong(hiraganaScore));
                    
                }

                if (!existingRecord.getHiraganaScore2().equals("-32") || longExistingRecordH1 > 0 ) {

                    existingRecord.setHiraganaScore2(Long.parseLong(hiraganaScore));
                    
                }

                if (!existingRecord.getHiraganaScore3().equals("-32") || longExistingRecordH2 > 0 ) {

                    existingRecord.setHiraganaScore3(Long.parseLong(hiraganaScore));
                    
                }
                

                ResponseEntity<String> res = new ResponseEntity("Dodano przelew", HttpStatus.OK);
            return res;

            } else {

            LatestScores latest = new LatestScores(username, Long.parseLong(hiraganaScore1), Long.parseLong(hiraganaScore2), Long.parseLong(hiraganaScore3), Long.parseLong(katakanaScore1), Long.parseLong(katakanaScore2), Long.parseLong(katakanaScore3));

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
