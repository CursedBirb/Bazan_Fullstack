package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import controllers.models.Users;
import controllers.repositories.UsersRepository;

@Component("loginAuth")
public class AuthService {

    @Autowired
    UsersRepository urepo;

    public boolean authService(String username, String password) {

        Users doesThisUserExist = urepo.findByUsername(username);

        if(doesThisUserExist == null) {

            return false;

        }

        if (!doesThisUserExist.getPassword().equals(password)) {

            return false;
            
        }

        return true;

    }
    
}
