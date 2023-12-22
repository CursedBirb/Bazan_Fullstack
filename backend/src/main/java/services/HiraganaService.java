package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import controllers.models.Hiragana;
import controllers.repositories.HiraganaRepository;

@Service
public class HiraganaService {

    @Autowired 
    private HiraganaRepository hRepository;
    
    public List<Hiragana> getRecordById() {
        return hRepository.findAll();
    }

}
