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

import common.HHiragana;
import controllers.models.Hiragana;
import controllers.repositories.HiraganaRepository;


@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/api/v1")
public class HiraganaController {
    
    @Autowired HiraganaRepository hiraganaRepository;

    @RequestMapping(value = "/gethiraganarecord", method=RequestMethod.POST)
    public ResponseEntity<ArrayList<HHiragana>> getHiraganaRecords (ServletRequest request) {
        
        try
        {
                
            //List<Transfer> latestScoresList = latestScoresRepository.findByUsername(userName);
            List<Hiragana> hiraganaList = hiraganaRepository.findAll();

            if (hiraganaList==null)
            {
                throw new IllegalArgumentException("Nie ma danych");
            }

            ArrayList<HHiragana> locHiraganaList = new ArrayList<HHiragana>();

            for (int i=1; i<(hiraganaList.size() + 1); i++)
            {
                Hiragana records = hiraganaRepository.getOne(i);
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
