package ie.cct.gergarage.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ie.cct.gergarage.model.ApiResponse;
import ie.cct.gergarage.model.Login;
import ie.cct.gergarage.model.User;
import ie.cct.gergarage.service.UserService;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ApiResponse signup(@RequestBody User user){
        return userService.create(user);
    }

    @PostMapping("/login")
    public ApiResponse login(@RequestBody Login login){
        return userService.login(login);
    }
    
    @GetMapping("/list-users")
    public ApiResponse listUsers(){
        return userService.list();
    }
}
