package controllers;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
    public ResponseEntity<ArrayList<LLatestScores>> getTransfers(ServletRequest request) {

        try
        {
                
            //List<Transfer> latestScoresList = latestScoresRepository.findByUsername(userName);
            List<LatestScores> latestScoresList = latestScoresRepository.findAll();

            if (latestScoresList==null)
            {
                throw new IllegalArgumentException("Nie ma danych");
            }

            ArrayList<LLatestScores> locLatestScoresList = new ArrayList<LLatestScores>();

            for (int i=0; i<latestScoresList.size(); i++)
            {
                LatestScores scores = latestScoresList.get(i);
                LLatestScores locScores = new LLatestScores(scores);
                locLatestScoresList.add(locScores);
            }

            ResponseEntity<ArrayList<LLatestScores>> res = new ResponseEntity(locLatestScoresList, HttpStatus.OK);
            return res;

        }
        catch (Exception e)
        {
            ArrayList<LLatestScores> locLatestScoresList = new ArrayList<LLatestScores>();
            LLatestScores locScores = new LLatestScores();
            locScores.setUsername("ERROR:"+e.getMessage());
            locLatestScoresList.add(locScores);
            ResponseEntity<ArrayList<LLatestScores>> res = new ResponseEntity(locLatestScoresList, HttpStatus.OK);
            return res;
        }
    }
    
}
