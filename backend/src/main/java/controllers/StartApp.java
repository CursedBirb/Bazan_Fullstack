package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import controllers.models.Hiragana;
import controllers.repositories.HiraganaRepository;
import controllers.repositories.LatestScoresRepository;

@SpringBootApplication
public class StartApp implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(controllers.StartApp.class, args);
    }

    //Wstrzykniecie beana repozytorium
    @Autowired private HiraganaRepository repository;
    @Autowired private LatestScoresRepository repo2;
    
    
    @Override
    public void run(String... args) {

        //Wstawienie osob do bazy
        // repository.save(new Hiragana("A","qwerty"));
        // repository.save(new Hiragana("I","qwertyu"));
        // repository.save(new Hiragana("U","qwertyui"));
        // repository.save(new Hiragana("E","qwertyuio"));
        // repository.save(new Hiragana("O","qwertyuiop"));
        // repository.save(new Hiragana("Ka","asdfgh"));
        
        //----------------------------------------------------
        
        System.out.println("Osoby wszystkie...");
        List<Hiragana> hiraganaList = repository.findAll();
        for (int i=0; i<hiraganaList.size(); i++) {
            System.out.println(hiraganaList.get(i).toString());
	}

        System.out.println(repo2.findById(1).toString());
        System.out.println(repo2.findById(2).toString());
        System.out.println(repo2.findByUsername("Wolololo").toString());
        
    }

}

