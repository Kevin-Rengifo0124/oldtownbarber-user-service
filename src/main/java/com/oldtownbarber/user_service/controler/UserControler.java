package com.oldtownbarber.user_service.controler;

import com.oldtownbarber.user_service.model.User;
import com.oldtownbarber.user_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserControler {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/api/users")
    public User createUser(@RequestBody User user){
        return userRepository.save(user);
    }

    @GetMapping("/api/users")
    public User getUser() {
        User user = new User();
        user.setEmail("usuario@gmail.com");
        user.setFullName("Usuario");
        user.setPhone("3122512327");
        user.setRole("Customer");
        return user;
    }
}
