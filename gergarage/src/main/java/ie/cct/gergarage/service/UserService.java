package ie.cct.gergarage.service;

import ie.cct.gergarage.model.ApiResponse;
import ie.cct.gergarage.model.Login;
import ie.cct.gergarage.model.User;

// interface to deal with user
public interface UserService {

    ApiResponse create(User user);

    ApiResponse login(Login login);
    
    ApiResponse list();
    
}