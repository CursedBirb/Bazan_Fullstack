package com.cursed.bjs.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursed.bjs.models.Hiragana;
import com.cursed.bjs.repositories.HiraganaRepository;

@Service
public class HiraganaService {

    @Autowired 
    private HiraganaRepository hRepository;
    
    public List<Hiragana> getRecordById() {
        return hRepository.findAll();
    }

}
