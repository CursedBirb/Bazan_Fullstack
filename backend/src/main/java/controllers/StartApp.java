package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import controllers.models.Hiragana;
import controllers.repositories.HiraganaRepository;
import controllers.repositories.LatestScoresRepository;
import controllers.repositories.RolesRepository;
import controllers.repositories.UsersRepository;

@SpringBootApplication
@ComponentScan({"services", "controllers"})
@EntityScan("controllers.models")
@EnableJpaRepositories("controllers.repositories")
public class StartApp implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(controllers.StartApp.class, args);
    }

    //Wstrzykniecie beana repozytorium
    @Autowired private HiraganaRepository repo1;
    @Autowired private LatestScoresRepository repo2;
    @Autowired private UsersRepository repo3;
    @Autowired private RolesRepository repo4;
    
    
    @Override
    public void run(String... args) {

        //Wstawienie osob do bazy
        // repo1.save(new Hiragana("A","qwerty"));
        // repo1.save(new Hiragana("I","qwertyu"));
        // repo1.save(new Hiragana("U","qwertyui"));
        // repo1.save(new Hiragana("E","qwertyuio"));
        // repo1.save(new Hiragana("O","qwertyuiop"));
        // repo1.save(new Hiragana("Ka","asdfgh"));
        
        //----------------------------------------------------
        
        System.out.println("Osoby wszystkie...");
        List<Hiragana> hiraganaList = repo1.findAll();
        for (int i=0; i<hiraganaList.size(); i++) {
            System.out.println(hiraganaList.get(i).toString());
	}

        // System.out.println(repo2.findById(1).toString());
        // System.out.println(repo2.findById(2).toString());
        // System.out.println(repo2.findByUsername("Wolololo").toString());

        // BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        // String salt = "AChialbysWiedziec";
        // String encodedPassword = encoder.encode("rip");
        // System.out.println(encodedPassword);

        // Users rip = new Users("Rip", encodedPassword, "rip@gmail.com", 1);

        // repo3.save(rip);
        // Roles roleUser = repo4.findByRole("ROLE_USER");

        // rip.getRoles().add(roleUser);
        // roleUser.getUsers().add(rip);

        // repo3.save(rip);
        // repo4.save(roleUser);

        // repo3.save(new Users("Wolololo", encodedPassword, "Wolololo@wolololo.com", 1));
        
    }

}

