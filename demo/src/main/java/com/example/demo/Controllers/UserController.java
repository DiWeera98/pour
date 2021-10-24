package com.example.demo.Controllers;


import com.example.demo.Models.User;
import com.example.demo.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping(path="/authenticate")
    public String authenticate(@RequestBody User user){
        User user1 = userRepository.findByEmail(user.getEmail());
        if (user1==null){
            return "Invalid user";
        }
        if (user1.getPassword()!=user.getPassword()){
            return "Invalid password";
        }
        return user1.getId();
    }
}
