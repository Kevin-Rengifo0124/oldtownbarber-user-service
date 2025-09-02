package com.oldtownbarber.user_service.controller;

import com.oldtownbarber.user_service.exception.UserException;
import com.oldtownbarber.user_service.model.User;
import com.oldtownbarber.user_service.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/api/users")
    public User createUser(@RequestBody @Valid User user) {
        return userRepository.save(user);
    }

    @GetMapping("/api/users")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/api/users/{userId}")
    public User getUserById(@PathVariable("userId") Long id) throws Exception {
        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isPresent()) {
            return optionalUser.get();
        }

        throw new UserException("Usuario no encontrado");
    }

    @PutMapping("/api/users/{id}")
    public User updateUser(@RequestBody User user, @PathVariable Long id) throws Exception {
        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isEmpty()) {
            throw new UserException("Usuario no encontrado con id" + id);
        }

        User existingUser = optionalUser.get();

        existingUser.setFullName(user.getFullName());
        existingUser.setEmail(user.getEmail());
        existingUser.setRole(user.getRole());

        return userRepository.save(existingUser);
    }

    @DeleteMapping("/api/users/{id}")
    public String deleteUserById(@PathVariable Long id) throws Exception {
        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isEmpty()) {
            throw new UserException("Usuario no existe con id" + id);
        }

        userRepository.deleteById(optionalUser.get().getId());
        return "Usuario Eliminado";
    }
}
