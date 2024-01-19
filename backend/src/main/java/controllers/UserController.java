package controllers;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import controllers.models.DetailedUsers;
import controllers.models.Users;
import controllers.repositories.DetailedUsersRepository;
import controllers.repositories.UsersRepository;

@CrossOrigin(allowCredentials = "true",
            origins = "http://localhost:3000",
            allowedHeaders = {"Authorization","Content-Type"},
            maxAge = 3600,
            exposedHeaders = {"Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"})
@RestController
@RequestMapping("/api/v1")
public class UserController {
    


    @Autowired
    UsersRepository usersRepository;

    @Autowired
    DetailedUsersRepository detailedUsersRepository;

    @RequestMapping(value = "/adduser", method = RequestMethod.POST)
    public ResponseEntity<String> addUser(@RequestBody String jsonString)
    {
                    
        try {
            
            JSONObject obj = new JSONObject(jsonString);
            String username = obj.getString("username");
            String password = obj.getString("password");
            String email = obj.getString("email");
            String firstName = obj.getString("firstName");
            String lastName = obj.getString("lastName");
            String age = obj.getString("age");
            String countryOfOrigin = obj.getString("countryOfOrigin");

            Users existingRecord = usersRepository.findByUsername(username);

            if(existingRecord != null) {

                ResponseEntity<String> res = new ResponseEntity("User already exist", HttpStatus.OK);

                return res;

            } else {

                Users newestUser = new Users(username, password, email);
                usersRepository.save(newestUser);

                DetailedUsers newestDetailedUser = new DetailedUsers(username, firstName, lastName, Long.parseLong(age), countryOfOrigin);
                detailedUsersRepository.save(newestDetailedUser);

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
